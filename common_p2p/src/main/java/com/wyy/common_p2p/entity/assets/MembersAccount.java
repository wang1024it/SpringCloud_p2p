package com.wyy.common_p2p.entity.assets;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * (MembersAccount)实体类
 *
 * @author makejava
 * @since 2019-10-26 16:31:44
 */
public class MembersAccount implements Serializable {
    private static final long serialVersionUID = 846702651727697249L;
    //id
    private Integer id;

   //这是会员名
    private String membersName;
    //会员id
    private Integer membersId;
    //交易密码
    private String tradePassword;
    //账户可用余额
    private BigDecimal usableAmount;
    //账户待收利息
    private BigDecimal unReceiveInterest;
    //账户代收本金
    private BigDecimal unReceivePrincipal;
    //账户授信额度(初始1000)
    private BigDecimal borrowLimit;
    //支付宝唯一标识
    private String tradeCode;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMembersId() {
        return membersId;
    }

    public void setMembersId(Integer membersId) {
        this.membersId = membersId;
    }

    public String getTradePassword() {
        return tradePassword;
    }

    public void setTradePassword(String tradePassword) {
        this.tradePassword = tradePassword;
    }

    public BigDecimal getUsableAmount() {
        return usableAmount;
    }

    public void setUsableAmount(BigDecimal usableAmount) {
        this.usableAmount = usableAmount;
    }

    public BigDecimal getUnReceiveInterest() {
        return unReceiveInterest;
    }

    public void setUnReceiveInterest(BigDecimal unReceiveInterest) {
        this.unReceiveInterest = unReceiveInterest;
    }

    public BigDecimal getUnReceivePrincipal() {
        return unReceivePrincipal;
    }

    public void setUnReceivePrincipal(BigDecimal unReceivePrincipal) {
        this.unReceivePrincipal = unReceivePrincipal;
    }

    public BigDecimal getBorrowLimit() {
        return borrowLimit;
    }

    public void setBorrowLimit(BigDecimal borrowLimit) {
        this.borrowLimit = borrowLimit;
    }

    public String getTradeCode() {
        return tradeCode;
    }

    public void setTradeCode(String tradeCode) {
        this.tradeCode = tradeCode;
    }



    public String getMembersName() {
        return membersName;
    }

    public void setMembersName(String membersName) {
        this.membersName = membersName;
    }


}