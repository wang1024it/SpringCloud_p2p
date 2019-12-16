package com.wyy.common_p2p.entity.sys;

import java.io.Serializable;

/**
 * (Sysdict)实体类
 *
 * @author makejava
 * @since 2019-10-21 11:46:05
 */
public class Sysdict implements Serializable {
    private static final long serialVersionUID = -14551499178616369L;
    //id

    private Integer id;

    //字典编号（英文）
    private String sn;

    //字典名称（中文）
    private String title;
    //描述
    private String description;

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
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

}