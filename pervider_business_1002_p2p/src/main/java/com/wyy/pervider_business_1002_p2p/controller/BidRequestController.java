package com.wyy.pervider_business_1002_p2p.controller;


import com.wyy.common_p2p.constant.BorrowingConstant;
import com.wyy.common_p2p.entity.borrowing.BidRequest;
import com.wyy.common_p2p.entity.borrowing.RefundDetail;
import com.wyy.common_p2p.entity.members.Members;
import com.wyy.common_p2p.rpc.members.MembersFeignApi;
import com.wyy.common_p2p.utils.*;
import com.wyy.pervider_business_1002_p2p.service.BidRequestService;
import com.wyy.pervider_business_1002_p2p.service.RefundDetailService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bidRequest")
public class BidRequestController {
    @Resource
    private BidRequestService bidRequestService;
    @Resource
    private RefundDetailService refundDetailService;
    @Resource
    private MembersFeignApi membersFeignApi;

    /**
     * 这是根据id查询单个
     * @param id
     * @return
     */
    @GetMapping("/queryById")
    public BidRequest queryById(Integer id){
        System.out.println(id);
        return this.bidRequestService.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param  params 请求参数集
     * @return 结果集封装对象 
     */
    @GetMapping("queryPager")
    public PageUtils queryPager(@RequestParam Map<String, Object> params) {
         Query query = new Query(params);
         List<BidRequest> list = this.bidRequestService.queryPager(query);
         return new PageUtils(list, query.getTotal());
    }


    /**
     *查看当前用户的所有借款
     *
     * @param  params 请求参数集
     * @return 结果集封装对象
     */
    @GetMapping("membersBidRequest")
    public  PageUtils membersBidRequest(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
        //这是将用户id放入
        query.put("applierId", JwtSession.getCurrentMembersId());
        List<BidRequest> list = this.bidRequestService.queryPager(query);
        return new PageUtils(list, query.getTotal());
    }

    /**
     * 获取到当前用户借款项目 （也就是当前用户正在进行借款的项目 ）
     * @return
     */
    @GetMapping("/getCurrentBidRequest")
    public PageUtils getCurrentBidRequest(){
        BidRequest currentBidRequest = this.bidRequestService.getCurrentBidRequest(JwtSession.getCurrentMembersId());
        List list = new ArrayList(1);
        list.add(currentBidRequest);
        //使用这种方式是因为字典翻译的问题
        return new PageUtils(list, 1);
    }


    /**
     * 这是发起信用借贷
     * @param bidRequest
     * @return
     */
    @PostMapping("applicationCreditLoan")
    public R applicationCreditLoan(BidRequest bidRequest){
        //加上当前用户
        bidRequest.setMembersId(JwtSession.getCurrentMembersId());
        bidRequest.setApplierId(JwtSession.getCurrentMembersId());
        bidRequest.setApplyTime(new Date());
        //设置借贷类型
        bidRequest.setBidRequestType(BorrowingConstant.CREDIT_LOAN);
        //向数据库中插入当前用户的借款项目
        this.bidRequestService.insert(bidRequest);
        //设置当前用户的借款项目
        Members members = new Members();
        members.setId(JwtSession.getCurrentMembersId());
        members.setBidRequestId(this.bidRequestService.getMaxId());
        this.membersFeignApi.update(members);
        return R.ok("申请成功");
    }


    /**
     * 修改数据
     * 说明：修改状态的时候会触发对应的流程
     * @param bidRequest 实例对象
     * @return R 
     */
    @PostMapping("update")
    public  R update(BidRequest bidRequest) {
        //这里判断状态(这是满标审核通过后的还款中)
        if(bidRequest.getBidRequestState() == 4){
            //1、生成用户还款明细表（好让用户还款）
            List<RefundDetail> refundDetails = this.refundDetailService.calculationRefundDetail(bidRequest);
            //判断还款类型是否为到本还本息
            if(bidRequest.getReturnType() == BorrowingConstant.MATURITY_PRINCIPAL){
                RefundDetail refundDetail = refundDetails.get(0);
                refundDetail.setBidRequestId(bidRequest.getId());
                //设置借款用户
                refundDetail.setMembersId(JwtSession.getCurrentMembersId());
                //计算时间
                refundDetail.setDeadLine(RepaymentDateUtil.getDate(bidRequest.getMonthesReturn()));
                //添加数据
                this.refundDetailService.insert(refundDetail);
            }else {
                for (int i = 0; i < refundDetails.size(); i++) {
                    RefundDetail refundDetail = refundDetails.get(i);
                    //设置当前的借款项目id
                    refundDetail.setBidRequestId(bidRequest.getId());
                    //设置借款用户
                    refundDetail.setMembersId(JwtSession.getCurrentMembersId());
                    //计算时间
                    refundDetail.setDeadLine(RepaymentDateUtil.getDate(i + 1));
                    this.refundDetailService.insert(refundDetail);
                }
            }
            //这是满标审核失败的清空
        }else if (bidRequest.getBidRequestState() == 8){
            //回款吧
            this.bidRequestService.failedPayment(bidRequest.getId());
        }
        return R.update(this.bidRequestService.update(bidRequest));
    }


    /**
     * 满标审核通过
     * @param bidRequest
     * @return
     */
    @PostMapping("fullMarkYes")
    public R fullMarkYes(BidRequest bidRequest){
        //生成客户的还款计划
        List<RefundDetail> refundDetails = this.refundDetailService.calculationRefundDetail(bidRequest);
        //插入到数据库中去啦
        for (RefundDetail refundDetail : refundDetails){
            this.refundDetailService.insert(refundDetail);
        }
        bidRequest.setBidRequestState(4);
        //修改标的状态
        return R.update(this.bidRequestService.update(bidRequest));
    }



    /**
     * 满标审核通失败 （满标审核失败就会将所有投标人投资的钱反回去 ）
     * @param bidRequest
     * @return
     */
    @RequestMapping("fullMarkNo")
    public R fullMarkNo(BidRequest bidRequest){
        //将其他用户投资的钱还回去
        bidRequest.setBidRequestState(8);
        //回款操作
        this.bidRequestService.failedPayment(bidRequest.getMembersId());
        //返回操作结果
        return R.update(this .bidRequestService.update(bidRequest));
    }


}