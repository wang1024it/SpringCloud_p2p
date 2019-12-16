package com.wyy.common_p2p.entity.sys;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2019-10-19 18:44:38
 */
public class User implements Serializable {
    private static final long serialVersionUID = 441929465203466630L;
    //用户ID,主键
    private Integer userId;
    //用户账号
    private String userName;
    //用户密码=MD5+盐加密
    private String password;
    //盐
    private String salt;
    //创建日期
    private Date createdate;

    //用户标识: 0 不可用 1 可用
    /*@Dict(dicCode = "sy")*/
    private Integer userFlag;

    private List<Integer> roleIds;
    private String roleNames;


    public List<Integer> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Integer> roleIds) {
        this.roleIds = roleIds;
    }

    public String getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(String roleNames) {
        this.roleNames = roleNames;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
    
    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
    
    public Integer getUserFlag() {
        return userFlag;
    }

    public void setUserFlag(Integer userFlag) {
        this.userFlag = userFlag;
    }

}