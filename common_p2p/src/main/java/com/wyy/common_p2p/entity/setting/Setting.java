package com.wyy.common_p2p.entity.setting;

import java.io.Serializable;

/**
 * (Setting)实体类
 *
 * @author makejava
 * @since 2019-10-22 21:16:54
 */
public class Setting implements Serializable {
    private static final long serialVersionUID = -21996088341397573L;
    //设置项
    private String key;
    //这是项目的值

    private String value;

    
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}