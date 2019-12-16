package com.wyy.common_p2p.entity.borrowing;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * (BidRequest)实体类
 *
 * @author cpc
 * @since 2019-10-31 14:03:42
 */
public class BidRequest implements Serializable {
    private static final long serialVersionUID = -50741860166107407L;

    //id
    private Integer id;

    //还款方式 (0 一次付清 ，1 等额本息 ，2 等额本金)
    /*@Dict(dicCode = "repayment")*/
    private Integer returnType;

    //这是申请人名
    private String applierName;

    //贷款类型 (0 信用贷,1 车贷,2 房贷)
    /*@Dict(dicCode = "bid_request_type")*/
    private Integer bidRequestType;

    //贷款状态 （0 审核通过，1 审核失败，2 审核中，3 满标 ，4 还款中，5 逾期，6 投标超时、7 完成）
    /*@Dict(dicCode = "bid_request_state")*/
    private Integer bidRequestState;

    //贷款总额
    private BigDecimal bidRequestAmount;

    //贷款的年化利率
   /* @Dict(dicCode = "annual_interest_rate")*/
    private BigDecimal currentRate;

    //还款月数

    private Integer monthesReturn;


    //当前投标数量 冗余数量
    private Integer bidCount;

    //总利息
    private BigDecimal totalRewardAmount;
    //当前收到的投资总额
    private BigDecimal currentSum;
    //借款标题

    private String title;
    //借款描述

    private String description;
    //贷款安全信息
    private String note;
    //投标截止日期

    private Date disableDate;
    //借款人id

    private Integer membersId;
    //发标时间天数
    private Integer disableDays;
    //发布时间

    private Date publishTime;
    //备注
    private String remark;
    //审核时间

    private Date auditTime;
    //申请时间
    private Date applyTime;

    //审核人
    private Integer auditorId;

    //申请人id
    private Integer applierId;

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getReturnType() {
        return returnType;
    }

    public void setReturnType(Integer returnType) {
        this.returnType = returnType;
    }
    
    public Integer getBidRequestType() {
        return bidRequestType;
    }

    public void setBidRequestType(Integer bidRequestType) {
        this.bidRequestType = bidRequestType;
    }
    
    public Integer getBidRequestState() {
        return bidRequestState;
    }

    public void setBidRequestState(Integer bidRequestState) {
        this.bidRequestState = bidRequestState;
    }
    
    public BigDecimal getBidRequestAmount() {
        return bidRequestAmount;
    }

    public void setBidRequestAmount(BigDecimal bidRequestAmount) {
        this.bidRequestAmount = bidRequestAmount;
    }
    
    public BigDecimal getCurrentRate() {
        return currentRate;
    }

    public void setCurrentRate(BigDecimal currentRate) {
        this.currentRate = currentRate;
    }
    
    public Integer getMonthesReturn() {
        return monthesReturn;
    }

    public void setMonthesReturn(Integer monthesReturn) {
        this.monthesReturn = monthesReturn;
    }
    
    public Integer getBidCount() {
        return bidCount;
    }

    public void setBidCount(Integer bidCount) {
        this.bidCount = bidCount;
    }
    
    public BigDecimal getTotalRewardAmount() {
        return totalRewardAmount;
    }

    public void setTotalRewardAmount(BigDecimal totalRewardAmount) {
        this.totalRewardAmount = totalRewardAmount;
    }
    
    public BigDecimal getCurrentSum() {
        return currentSum;
    }

    public void setCurrentSum(BigDecimal currentSum) {
        this.currentSum = currentSum;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    public Date getDisableDate() {
        return disableDate;
    }

    public void setDisableDate(Date disableDate) {
        this.disableDate = disableDate;
    }
    
    public Integer getMembersId() {
        return membersId;
    }

    public void setMembersId(Integer membersId) {
        this.membersId = membersId;
    }
    
    public Integer getDisableDays() {
        return disableDays;
    }

    public void setDisableDays(Integer disableDays) {
        this.disableDays = disableDays;
    }
    
    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }
    
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }
    
    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }
    
    public Integer getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(Integer auditorId) {
        this.auditorId = auditorId;
    }
    
    public Integer getApplierId() {
        return applierId;
    }

    public void setApplierId(Integer applierId) {
        this.applierId = applierId;
    }

    public String getApplierName() {
        return applierName;
    }

    public void setApplierName(String applierName) {
        this.applierName = applierName;
    }
}