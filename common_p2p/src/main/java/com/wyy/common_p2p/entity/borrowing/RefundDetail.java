package com.wyy.common_p2p.entity.borrowing;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * (RefundDetail)实体类
 *
 * @author cpc
 * @since 2019-10-31 14:03:42
 */
public class RefundDetail implements Serializable {
    private static final long serialVersionUID = -90757739134302954L;

    //id
    private Integer id;
    //本期还款截止期限
    private Date deadLine;

    //还款时间
    private Date payDate;

    //本期还款总金额，利息 +本金 + 平台手续费
    private BigDecimal totalAmount;

    //本期还款本金
    private BigDecimal principal;

    //本期还款总利息
    private BigDecimal interest;

    // 第几期 (即第几个月)
    private int monthIndex;
    //本期还款状态（0 已还款，1待还款、2 逾期）

    private Integer state;
    //借款表标题

    private String bidRequestTitle;
    //这是用户id
    private Integer membersId;
    //这是借款表id

    private Integer bidRequestId;

    //平台手续费
    private BigDecimal handlingFee;
    private BigDecimal handlingFeeRate;


    public BigDecimal getHandlingFee() {
        return handlingFee;
    }

    public void setHandlingFee(BigDecimal handlingFee) {
        this.handlingFee = handlingFee;
    }

    public BigDecimal getHandlingFeeRate() {
        return handlingFeeRate;
    }

    public void setHandlingFeeRate(BigDecimal handlingFeeRate) {
        this.handlingFeeRate = handlingFeeRate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }
    
    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }
    
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    public BigDecimal getPrincipal() {
        return principal;
    }

    public void setPrincipal(BigDecimal principal) {
        this.principal = principal;
    }
    
    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }
    
    public int getMonthIndex() {
        return monthIndex;
    }

    public void setMonthIndex(int monthIndex) {
        this.monthIndex = monthIndex;
    }
    
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
    
    public String getBidRequestTitle() {
        return bidRequestTitle;
    }

    public void setBidRequestTitle(String bidRequestTitle) {
        this.bidRequestTitle = bidRequestTitle;
    }
    
    public Integer getMembersId() {
        return membersId;
    }

    public void setMembersId(Integer membersId) {
        this.membersId = membersId;
    }
    
    public Integer getBidRequestId() {
        return bidRequestId;
    }

    public void setBidRequestId(Integer bidRequestId) {
        this.bidRequestId = bidRequestId;
    }

}