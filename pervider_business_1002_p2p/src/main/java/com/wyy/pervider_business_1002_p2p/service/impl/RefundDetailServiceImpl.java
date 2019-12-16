package com.wyy.pervider_business_1002_p2p.service.impl;

import com.wyy.common_p2p.constant.BorrowingConstant;
import com.wyy.common_p2p.entity.borrowing.BidRequest;
import com.wyy.common_p2p.entity.borrowing.RefundDetail;
import com.wyy.common_p2p.utils.BigDecimalUtil;
import com.wyy.common_p2p.utils.Query;
import com.wyy.pervider_business_1002_p2p.dao.RefundDetailDao;
import com.wyy.pervider_business_1002_p2p.service.RefundDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service("refundDetailService")
public class RefundDetailServiceImpl implements RefundDetailService {
    @Resource
    private RefundDetailDao refundDetailDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RefundDetail queryById(Integer id) {
        return this.refundDetailDao.queryById(id);
    }

    /**
     * 通过query对象查询
     *
     * @param  query 分页查询对象 
     * @return 对象列表
     */
    @Override
    public List<RefundDetail> queryPager(Query query) {
        return this.refundDetailDao.queryPager(query);
    }

    /**
     * 新增数据
     *
     * @param refundDetail 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(RefundDetail refundDetail) {
        return this.refundDetailDao.insert(refundDetail);
    }

    /**
     * 修改数据
     *
     * @param refundDetail 实例对象
     * @return 实例对象
     */
    @Override
    public int update(RefundDetail refundDetail) {
        return this.refundDetailDao.update(refundDetail);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer id) {
        return this.refundDetailDao.deleteById(id);
    }


    /**
     * 这是计算还款计划
     * @param bidRequest
     * @return
     */
    @Override
    public List<RefundDetail> calculationRefundDetail(BidRequest bidRequest){
        int type = bidRequest.getReturnType();
        List<RefundDetail> refundDetails = new ArrayList<>();
        if(type == BorrowingConstant.EQUAL_PRINCIPAL){ //等额本金
            //计算出利息集合
            List<BigDecimal>  interests = BigDecimalUtil.equalPrincipalMonthlyInterests(bidRequest.getBidRequestAmount(),bidRequest.getCurrentRate(), bidRequest.getMonthesReturn());
            //每月应还本金
            BigDecimal periodPrincipal = BigDecimalUtil.periodPrincipal(bidRequest.getBidRequestAmount(), bidRequest.getMonthesReturn());
            for (int i = 0; i < interests.size(); i++) {
                RefundDetail refundDetail = new RefundDetail();
                //还款期数
                refundDetail.setMonthIndex(i + 1);
                //还款本金
                refundDetail.setPrincipal(periodPrincipal);
                //还款利息
                refundDetail.setInterest(interests.get(i));
                //共计
                refundDetail.setTotalAmount(periodPrincipal.add(interests.get(i)));
                refundDetails.add(refundDetail);
            }
        }else if(type == BorrowingConstant.EQUAL_INTEREST){//等额本息
            //每月应还本金
            BigDecimal periodPrincipal = BigDecimalUtil.periodPrincipal(bidRequest.getBidRequestAmount(), bidRequest.getMonthesReturn());
            //这是每个月应还利息
            BigDecimal interest = BigDecimalUtil.equalAmountPrincipal(bidRequest.getBidRequestAmount(),bidRequest.getCurrentRate(), bidRequest.getMonthesReturn());
            //计算出每个月应还利息（每月应还本金 - 每月应还利息）
            for (int i = 1; i <= bidRequest.getMonthesReturn(); i++) {
                RefundDetail refundDetail = new RefundDetail();
                //还款期数
                refundDetail.setMonthIndex(i);
                //还款本金
                refundDetail.setPrincipal(periodPrincipal);
                //还款利息
                refundDetail.setInterest(interest);
                //共计
                refundDetail.setTotalAmount(periodPrincipal.add(interest));
                refundDetails.add(refundDetail);
            }

        }else {//到期还本息
            RefundDetail refundDetail = new RefundDetail();
            //还款期数
            refundDetail.setMonthIndex(1);
            //还款本金
            refundDetail.setPrincipal(bidRequest.getBidRequestAmount());
            //还款利息
            BigDecimal totalInterest  = BigDecimalUtil.maturityPrincipalAndInterestInterest(bidRequest.getBidRequestAmount(),bidRequest.getCurrentRate(), bidRequest.getMonthesReturn());
            refundDetail.setInterest(totalInterest);
            //共计
            refundDetail.setTotalAmount(bidRequest.getBidRequestAmount().add(totalInterest));
            refundDetails.add(refundDetail);
        }
        return refundDetails;
    }


}