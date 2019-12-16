package com.wyy.common_p2p.entity.members;

import java.io.Serializable;
import java.util.Date;

/**
 * (MembersDetail)实体类
 *
 * @author makejava
 * @since 2019-10-26 16:09:20
 */
public class MembersDetail implements Serializable {
    private static final long serialVersionUID = -53311509510063996L;
    //会员明细id

    private Integer id;
    //会员id

    private Integer membersId;
    //头像

    private String headPhoto;
    //电话号码

    private String phone;
    //性别

    private String sex;
    //个人学历(数据字典)
    private String myselfBackground;
    //月收入(数据字典)

    private Date monthlyIncome;
    //婚姻情况(数据字典)

    private String maritalStatus;
    //子女情况(数据字典)

    private String children;
    //有无住房(数据字典)

    private String house;

    
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
    
    public String getHeadPhoto() {
        return headPhoto;
    }

    public void setHeadPhoto(String headPhoto) {
        this.headPhoto = headPhoto;
    }
    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    
    public String getMyselfBackground() {
        return myselfBackground;
    }

    public void setMyselfBackground(String myselfBackground) {
        this.myselfBackground = myselfBackground;
    }
    
    public Date getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(Date monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }
    
    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
    
    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }
    
    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

}