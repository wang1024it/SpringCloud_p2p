package com.wyy.common_p2p.entity.members;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * (Members)实体类
 *
 * @author makejava
 * @since 2019-10-25 16:10:56
 */
public class Members implements Serializable {
    private static final long serialVersionUID = -39066927715741719L;
    //id
    private Integer id;
    //用户名

    private String name;
    //密码

    private String password;
    //认证分数
    private Integer certificationScore;
    //是否身份认证(0 yes 1 no 默认为1)

    private Integer isIdentityAuthentication;
    //是否可用(0 可用，1 不可用)

    private Integer membersState;
    //活期日利率（待删除）
    private BigDecimal rate;
    //
//活期日获利时间
    private Object rateTime;
    //bid_request_id
    private Integer bidRequestId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Integer getCertificationScore() {
        return certificationScore;
    }

    public void setCertificationScore(Integer certificationScore) {
        this.certificationScore = certificationScore;
    }
    
    public Integer getIsIdentityAuthentication() {
        return isIdentityAuthentication;
    }

    public void setIsIdentityAuthentication(Integer isIdentityAuthentication) {
        this.isIdentityAuthentication = isIdentityAuthentication;
    }
    
    public Integer getMembersState() {
        return membersState;
    }

    public void setMembersState(Integer membersState) {
        this.membersState = membersState;
    }
    
    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
    
    public Object getRateTime() {
        return rateTime;
    }

    public void setRateTime(Object rateTime) {
        this.rateTime = rateTime;
    }
    
    public Integer getBidRequestId() {
        return bidRequestId;
    }

    public void setBidRequestId(Integer bidRequestId) {
        this.bidRequestId = bidRequestId;
    }




}