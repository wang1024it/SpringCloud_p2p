package com.wyy.common_p2p.entity.members;


import java.io.Serializable;
import java.util.Date;

/**
 * (MembersRealname)实体类
 *
 * @author makejava
 * @since 2019-10-23 15:51:06
 */
public class MembersRealname implements Serializable {
    private static final long serialVersionUID = 178478305468496632L;
    //id
    private Integer id;
    //真实姓名
    private String realname;
    //性别

    private String sex;
    //出生日期
    private Date bornDate;
    //身份证号码
    private String idNumber;
    //证件地址
    private String address;
    //状态（0审核成功，1待审核，2审核失败)
    /*@Dict(dicCode = "is_identity_authentication")*/
    private Integer state;
    //身份证正面图片路径
    private String image1;
    //身份证反面图片路径
    private String image2;
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

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }
    
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    
    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }
    
    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }
    
    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
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

}