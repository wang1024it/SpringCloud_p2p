package com.wyy.common_p2p.entity.assets;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * (MoneyWithdraw)实体类
 *
 * @author makejava
 * @since 2019-10-24 17:02:01
 */
public class MoneyWithdraw implements Serializable {
    private static final long serialVersionUID = 136766122229903007L;
    //id
    private Integer id;
    //状态 (0 成功，1 失败，2 待审核)
    /*@Dict(dicCode = "money_withdraw_state")*/
    private Integer state;
    //备注

    private String remark;
    //审核时间

    private Date auditTime;
    //申请时间

    private Date applyTime;
    //审核人id

    private Integer auditorId;
    //申请人id

    private Integer membersId;
    //真实的提现金额

    private BigDecimal amount;
    //手续费金额（0.01的手续费）

    private BigDecimal fee;
    //（说明：第3方转账唯一标识）
    private String tradeCode;

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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
    
    public Integer getMembersId() {
        return membersId;
    }

    public void setMembersId(Integer membersId) {
        this.membersId = membersId;
    }
    
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    
    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }
    
    public String getTradeCode() {
        return tradeCode;
    }

    public void setTradeCode(String tradeCode) {
        this.tradeCode = tradeCode;
    }

}