package com.wyy.common_p2p.entity.borrowing;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * (Bid)实体类
 *
 * @author cpc
 * @since 2019-10-31 14:03:42
 */
public class Bid implements Serializable {
    private static final long serialVersionUID = -42111011396759103L;
    //id
    private Integer id;
    //实际利率
    private BigDecimal actualRate;
    //投标额度
    private BigDecimal availableAmount;
    //所投标的id
    private Integer bidRequestId;
    //投标会员id
    private Integer membersId;
    //投标时间
    private Date bidTime;
    //这是投标人名字
    private String membersName;

    public String getMembersName() {
        return membersName;
    }

    public void setMembersName(String membersName) {
        this.membersName = membersName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public BigDecimal getActualRate() {
        return actualRate;
    }

    public void setActualRate(BigDecimal actualRate) {
        this.actualRate = actualRate;
    }
    
    public BigDecimal getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(BigDecimal availableAmount) {
        this.availableAmount = availableAmount;
    }
    
    public Integer getBidRequestId() {
        return bidRequestId;
    }

    public void setBidRequestId(Integer bidRequestId) {
        this.bidRequestId = bidRequestId;
    }
    
    public Integer getMembersId() {
        return membersId;
    }

    public void setMembersId(Integer membersId) {
        this.membersId = membersId;
    }
    
    public Date getBidTime() {
        return bidTime;
    }

    public void setBidTime(Date bidTime) {
        this.bidTime = bidTime;
    }
}