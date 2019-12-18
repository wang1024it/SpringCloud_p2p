package com.wyy.pervider_shiro_1006_p2p.dao;

import com.wyy.common_p2p.entity.sys.Menu;
import com.wyy.common_p2p.entity.sys.Permission;
import com.wyy.common_p2p.utils.Query;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Permission)表数据库访问层
 *
 * @author cpc
 * @since 2019-10-19 21:18:15
 */
public interface PermissionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param perId 主键
     * @return 实例对象
     */
    Permission queryById(Integer perId);

    /**
     * 通过query对象查询
     *
     * @param  query 分页查询对象 
     * @return 对象列表
     */
    List<Permission> queryPager(Query query);

    /**
     * 新增数据
     *
     * @param permission 实例对象
     * @return 影响行数
     */
    int insert(Permission permission);

    /**
     * 修改数据
     *
     * @param permission 实例对象
     * @return 影响行数
     */
    int update(Permission permission);

    /**
     * 通过主键删除数据
     *
     * @param perId 主键
     * @return 影响行数
     */
    int deleteById(Integer perId);

    /**
     * 查询用户菜单（查询指定父菜单下的子菜单）
     * @param pid
     * @param userId
     * @return
     */
    List<Menu> queryChildern(@Param("pid") Integer pid, @Param("userId") Integer userId);

    /**
     * 这是根据父id找子菜单
     * @param pid
     * @return
     */
    List<Menu> queryModules(@Param("pid") Integer pid);


    /**
     * 这是查出角色所拥有的权限 id
     * @param roleId
     * @return
     */
    List<Integer> queryIdByRole(@Param("roleId") Integer roleId);



}