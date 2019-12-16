package com.wyy.common_p2p.entity.borrowing;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * (ReturnDetail)实体类
 *
 * @author cpc
 * @since 2019-10-31 14:03:43
 */
public class ReturnDetail implements Serializable {
    private static final long serialVersionUID = 519323745850922278L;
    //id
    private Integer id;
    //投标总额

    private BigDecimal bidAmount;
    //对应的投标ID

    private Integer bidId;
    //本期还款总金额(=本金+利息)

    private BigDecimal totalAmount;
    //本期应还款本金
    private BigDecimal principal;
    //本期应还款利息
    private BigDecimal interest;
    //第几期（即第几个月）
    private Integer monthIndex;
    //本期还款截止时间

    private Date deadLine;
    //实际付款日期
    private Date payDate;
    //还款方式

    private Integer returnType;
    //所属还款计划id

    private Integer refundDetailId;
    //还款人(即发标人)

    private Integer fromMembersId;
    //收款人(即投标人)
    private Integer toMembersId;
    //这是对应的投标 标题
    private String title;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public BigDecimal getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(BigDecimal bidAmount) {
        this.bidAmount = bidAmount;
    }
    
    public Integer getBidId() {
        return bidId;
    }

    public void setBidId(Integer bidId) {
        this.bidId = bidId;
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
    
    public Integer getMonthIndex() {
        return monthIndex;
    }

    public void setMonthIndex(Integer monthIndex) {
        this.monthIndex = monthIndex;
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
    
    public Integer getReturnType() {
        return returnType;
    }

    public void setReturnType(Integer returnType) {
        this.returnType = returnType;
    }
    
    public Integer getRefundDetailId() {
        return refundDetailId;
    }

    public void setRefundDetailId(Integer refundDetailId) {
        this.refundDetailId = refundDetailId;
    }
    
    public Integer getFromMembersId() {
        return fromMembersId;
    }

    public void setFromMembersId(Integer fromMembersId) {
        this.fromMembersId = fromMembersId;
    }
    
    public Integer getToMembersId() {
        return toMembersId;
    }

    public void setToMembersId(Integer toMembersId) {
        this.toMembersId = toMembersId;
    }

}