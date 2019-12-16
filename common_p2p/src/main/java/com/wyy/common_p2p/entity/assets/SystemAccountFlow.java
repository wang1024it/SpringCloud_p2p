package com.wyy.common_p2p.entity.assets;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * (SystemAccountFlow)实体类
 *
 * @author cpc
 * @since 2019-12-10 23:04:39
 */
public class SystemAccountFlow implements Serializable {
    private static final long serialVersionUID = -95462531625629502L;
    
    private Integer id;
    
    private Integer otype;
    
    private BigDecimal amount;
    
    private Date otime;

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getOtype() {
        return otype;
    }

    public void setOtype(Integer otype) {
        this.otype = otype;
    }
    
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    
    public Date getOtime() {
        return otime;
    }

    public void setOtime(Date otime) {
        this.otime = otime;
    }

}