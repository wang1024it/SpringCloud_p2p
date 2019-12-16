package com.wyy.pervider_business_1002_p2p.controller;


import com.wyy.common_p2p.entity.assets.MembersAccount;
import com.wyy.common_p2p.entity.assets.SystemAccountFlow;
import com.wyy.common_p2p.entity.borrowing.Bid;
import com.wyy.common_p2p.entity.borrowing.BidRequest;
import com.wyy.common_p2p.entity.borrowing.RefundDetail;
import com.wyy.common_p2p.entity.borrowing.ReturnDetail;
import com.wyy.common_p2p.rpc.assets.MembersAccountFeignApi;
import com.wyy.common_p2p.rpc.assets.SystemAccountFlowFeignApi;
import com.wyy.common_p2p.utils.JwtSession;
import com.wyy.common_p2p.utils.PageUtils;
import com.wyy.common_p2p.utils.Query;
import com.wyy.common_p2p.utils.R;
import com.wyy.pervider_business_1002_p2p.service.BidRequestService;
import com.wyy.pervider_business_1002_p2p.service.BidService;
import com.wyy.pervider_business_1002_p2p.service.RefundDetailService;
import com.wyy.pervider_business_1002_p2p.service.ReturnDetailService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/refundDetail")
public class RefundDetailController {

    //这是还款server层对象
    @Resource
    private RefundDetailService refundDetailService;
    //账户feign 调用 对象
    @Resource
    private MembersAccountFeignApi membersAccountFeignApi;
    @Resource
    private BidService bidService;
    @Resource
    private BidRequestService bidRequestService;

    @Resource
    private ReturnDetailService returnDetailService;


    //这是系统账户流水远程feign调用对象
    @Resource
    private SystemAccountFlowFeignApi systemAccountFlowFeignApi;
    /**
     * 分页查询
     *
     * @param  params 请求参数集
     * @return 结果集封装对象 
     */
    @GetMapping("queryPager")
    public PageUtils queryPager(@RequestParam Map<String, Object> params) {
         Query query = new Query(params);
         List<RefundDetail> list = refundDetailService.queryPager(query);
         return new PageUtils(list, query.getTotal());
    }


    /**
     * 新增数据
     *
     * @param refundDetail 实例对象
     * @return R 
     */
    @PostMapping("add")
    public R add(RefundDetail refundDetail) {
        return R.update(refundDetailService.insert(refundDetail));
    }
    
    
    
    /**
     * 修改数据
     *
     * @param refundDetail 实例对象
     * @return R 
     */
    @PostMapping("update")
    public  R update(RefundDetail refundDetail) {
        return R.update(refundDetailService.update(refundDetail));
    }
    
    /**
     * 删除数据
     *
     * @param id 主键
     * @return R 
     */
    @PostMapping("del")
    public  R del(Integer id) {
        return R.update(refundDetailService.deleteById(id));
    }

    /**
     * 这是计算还款计划
     * @param bidRequest 这是计算对象
     * @return
     */
    @RequestMapping("calculationRefundDetail")
    public R calculationRefundDetail(BidRequest bidRequest){
        R ok = R.ok();
        ok.put("refundDetails", this.refundDetailService.calculationRefundDetail(bidRequest));
        return ok;
    }


    /**
     * 这是还款 （对应的是每期还钱 ）
     * 还钱步骤如下：
     *       扣除用户账户上对应的钱,将当前还款期书设置为还款状态 （如果当前用户的钱不够就告知对方要充值）
     *       将还的钱，连本带利反给投标者，并且还要反一部分给平台本身
     * @param refundDetail  还款数据包装对象 （有对应的还款日期和时间）
     * @return
     */
    @PostMapping("/repayment")
    public R repayment(RefundDetail refundDetail){
        //获取当前用户的账户对象
        MembersAccount membersAccount = membersAccountFeignApi.queryByMembersId(JwtSession.getCurrentMembersId());
        //账户上的剩额必须大于等于要还的钱
        if(!(membersAccount.getUsableAmount().compareTo(refundDetail.getTotalAmount()) > -1)){
            return R.error("账户余额不足，请先充值");
        }
        //返现给投标者
        List<Bid> bids = bidService.queryByRequestId(refundDetail.getBidRequestId());
        //获取当前借款对象
        BidRequest bidRequest =  bidRequestService.queryById(refundDetail.getBidRequestId());
        BigDecimal bidRequestAmount = bidRequest.getBidRequestAmount();
        bids.forEach(bid -> {
            //给对用的账户加钱
            MembersAccount amount = membersAccountFeignApi.queryByMembersId(bid.getMembersId());
            //当前投标额度占总额度的百代之多少
            BigDecimal proportion = bid.getAvailableAmount().divide(bidRequestAmount, 20, BigDecimal.ROUND_DOWN);
            //根据占比拿钱
            amount.getUsableAmount().add(refundDetail.getTotalAmount().multiply(proportion));
            //生成回款记录
            ReturnDetail returnDetail = new ReturnDetail();
            returnDetail.setBidAmount(bid.getAvailableAmount());
            returnDetail.setBidId(bid.getId());
            returnDetail.setTotalAmount(refundDetail.getTotalAmount().multiply(proportion));
            returnDetail.setPrincipal(refundDetail.getPrincipal().multiply(proportion));
            returnDetail.setInterest(refundDetail.getInterest().multiply(proportion));
            returnDetail.setMonthIndex(refundDetail.getMonthIndex());
            returnDetail.setDeadLine(refundDetail.getDeadLine());
            returnDetail.setPayDate(new Date());
            returnDetail.setReturnType(bidRequest.getBidRequestType());
            returnDetail.setRefundDetailId(refundDetail.getId());
            returnDetail.setFromMembersId(JwtSession.getCurrentMembersId());
            returnDetail.setToMembersId(bid.getMembersId());
            //插入回款明细
            returnDetailService.insert(returnDetail);
            //修改对应投标用户的钱
            membersAccountFeignApi.update(amount);
        });
        //将借贷的手续费给平台 .......等待完成
        SystemAccountFlow systemAccountFlow = new SystemAccountFlow();
        systemAccountFlow.setAmount(refundDetail.getHandlingFee());
        systemAccountFlow.setOtime(new Date());
        systemAccountFlow.setDescription("还款手续费");
        systemAccountFlowFeignApi.insert(systemAccountFlow);
        //将状态修改成还款状态
        return R.update(this.refundDetailService.update(refundDetail));
    }
}