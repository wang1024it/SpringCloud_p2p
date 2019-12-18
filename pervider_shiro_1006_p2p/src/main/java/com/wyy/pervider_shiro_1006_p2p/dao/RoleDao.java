package com.wyy.pervider_shiro_1006_p2p.dao;

import com.wyy.common_p2p.entity.sys.Role;
import com.wyy.common_p2p.utils.Query;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * (Role)表数据库访问层
 *
 * @author cpc
 * @since 2019-10-20 08:15:40
 */
public interface RoleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param roleId 主键
     * @return 实例对象
     */
    Role queryById(Integer roleId);

    /**
     * 通过query对象查询
     *
     * @param  query 分页查询对象 
     * @return 对象列表
     */
    List<Role> queryPager(Query query);

    /**
     * 新增数据
     *
     * @param role 实例对象
     * @return 影响行数
     */
    int insert(Role role);

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 影响行数
     */
    int update(Role role);

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 影响行数
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
     * 获取用户所拥有的角色
     * @return
     */
    List<Map> getUserRole(Integer userId);

    /**
     * 获取角色的最大Id
     * @return
     */
    Integer getMaxId();


    /**
     * 添加角色权限绑定
     * @param roleId
     * @param perId
     * @return
     */
    @Insert("insert into role_permission(role_id, per_id) values (#{roleId}, #{perId})")
    int addRolePermission(@Param("roleId") Integer roleId, @Param("perId") Integer perId);

    /**
     * 这是删除角色权限绑定 更具角色id来删除
     * @param roleId 角色id
     * @return
     */
    int delRolePermissionByRoleId(Integer roleId);



}