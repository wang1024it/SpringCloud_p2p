package com.wyy.common_p2p.entity.members;

import java.io.Serializable;
import java.util.Date;

/**
 * (MembersMaterials)实体类
 *
 * @author makejava
 * @since 2019-10-25 15:29:52
 */
public class MembersMaterials implements Serializable {
    private static final long serialVersionUID = -10392917234342595L;
    //id
    private Integer id;
    //审核状态（0审核成功，1待审核，2审核失败）
    private Object state;
    //审核说明

    private String remark;
    //审核时间
    private Date auditTime;
    //申请时间
    private Date applyTime;
    //审核人id
    private Integer auditorId;
    //申请人id
    private Integer membersId;
    //材料得分

    private Object score;
    //文件路径
    private String file;
    //图片路径
    private String image;

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Object getState() {
        return state;
    }

    public void setState(Object state) {
        this.state = state;
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
    
    public Object getScore() {
        return score;
    }

    public void setScore(Object score) {
        this.score = score;
    }
    
    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
    
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}