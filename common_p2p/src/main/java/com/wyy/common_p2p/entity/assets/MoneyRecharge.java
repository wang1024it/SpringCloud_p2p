package com.wyy.common_p2p.entity.assets;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * (MoneyRecharge)实体类
 *
 * @author makejava
 * @since 2019-10-24 19:12:17
 */
public class MoneyRecharge implements Serializable {
    private static final long serialVersionUID = 147714425601340468L;
    //id
    private Integer id;
    //支付宝唯一标识（账号）
    private String tradeCode;
    //交易时间

    private Date tradeTime;
    //交易金额

    private BigDecimal amount;
    //这是会员Id

    private Integer membersId;

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getTradeCode() {
        return tradeCode;
    }

    public void setTradeCode(String tradeCode) {
        this.tradeCode = tradeCode;
    }
    
    public Date getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(Date tradeTime) {
        this.tradeTime = tradeTime;
    }
    
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    
    public Integer getMembersId() {
        return membersId;
    }

    public void setMembersId(Integer membersId) {
        this.membersId = membersId;
    }

}