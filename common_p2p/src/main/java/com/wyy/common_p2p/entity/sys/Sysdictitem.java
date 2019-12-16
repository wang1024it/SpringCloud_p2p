package com.wyy.common_p2p.entity.sys;

import java.io.Serializable;

/**
 * (Sysdictitem)实体类
 *
 * @author makejava
 * @since 2019-10-21 11:47:44
 */
public class Sysdictitem implements Serializable {
    private static final long serialVersionUID = -63963288749491977L;
    //id
    private Integer id;
    //数据字典明细对应的分类id

    private Integer parentid;
    //数据字典明细显示名称

    private String title;
    //字典明细值

    private String value;
    //数据字典明细在该分类中的排序

    private Integer sequence;
    //描述
    private String description;

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}