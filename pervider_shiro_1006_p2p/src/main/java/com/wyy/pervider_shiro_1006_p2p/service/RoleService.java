package com.wyy.pervider_shiro_1006_p2p.service;

import com.wyy.common_p2p.entity.sys.Role;
import com.wyy.common_p2p.utils.Query;

import java.util.List;
import java.util.Map;

/**
 * (Role)表服务接口
 *
 * @author cpc
 * @since 2019-10-20 08:15:40
 */
public interface RoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param roleId 主键
     * @return 实例对象
     */
    Role queryById(Integer roleId);


    /**
     * 新增数据
     *
     * @param role 实例对象
     * @param permissionIds 角色要绑定的权限
     * @return 添加行数
     */
     int insert(Role role, String permissionIds);

    /**
     * 通过query对象查询
     *
     * @param  query 分页查询对象 
     * @return 对象列表
     */
    List<Role> queryPager(Query query);


    /**
     * 修改数据
     *
     * @param role 实例对象
     * @param permissionIds 这是要绑定的权限id数据
     * @return 修改行数
     */
     int update(Role role, String permissionIds);

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 删除行数
     */
    int deleteById(Integer roleId);


    /**
     * 查询指定角色名的角色
     * @param roleName
     * @return
     */
    Role queryByName(String roleName);

    /**
     * 根据指定的角色编码查询角色
     * @param coding
     * @return
     */
    Role queryByCoding(String coding);

    /**
     * 获取角色下拉
     * @return
     */
    List<Map> getRoleSelect();



    /**
     * 添加角色权限绑定
     * @param roleId
     * @param perId
     * @return
     */
    int addRolePermission(Integer roleId, Integer perId);

    /**
     * 角色授权的方法
     * @param roleId
     * @param permissionIds
     * @return
     */
    int authorization(Integer roleId, String permissionIds);

}