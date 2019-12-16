package com.wyy.common_p2p.entity.sys;

import java.io.Serializable;
import java.util.Date;

/**
 * (Role)实体类
 *
 * @author makejava
 * @since 2019-10-20 08:15:41
 */
public class Role implements Serializable {
    private static final long serialVersionUID = -68283677249379469L;
    //角色ID,主键
    private Integer roleId;
    //角色名称
    private String roleName;
    //角色编码
    private String roleCoding;
    //角色描述
    private String roleDesc;
    //角色创建时间
    private Date creationTime;
    //角色更新时间
    private Date updateTime;
    
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
    
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public String getRoleCoding() {
        return roleCoding;
    }

    public void setRoleCoding(String roleCoding) {
        this.roleCoding = roleCoding;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public Role() {
    }
}