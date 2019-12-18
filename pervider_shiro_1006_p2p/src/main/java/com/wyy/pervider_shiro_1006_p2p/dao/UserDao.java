package com.wyy.pervider_shiro_1006_p2p.dao;

import com.wyy.common_p2p.entity.sys.User;
import com.wyy.common_p2p.utils.Query;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * (User)表数据库访问层
 *
 * @author cpc
 * @since 2019-10-19 17:34:51
 */
public interface UserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param userid 主键
     * @return 实例对象
     */
    User queryById(Integer userid);

    /**
     * 根据用户名查询用户对象
     * @param userName
     * @return
     */
    User queryByName(String userName);


    /**
     *根据用户id获取到所有角色
     * @param userId
     * @return
     */
    public Set<String> getRolesByUserId(Integer userId);

    /**
     * 根据用户id获取所有权限
     * @param userId
     * @return
     */
    public Set<String> getPersByUserId(Integer userId);


    /**
     * 通过query对象查询
     *
     * @param  query 分页查询对象 
     * @return 对象列表
     */
    List<User> queryPager(Query query);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int update(User user);

    /**
     * 通过主键删除数据
     *
     * @param userid 主键
     * @return 影响行数
     */
    int deleteById(Integer userid);

    /**
     * 获取最多id
     * @return
     */
    Integer getMaxId();

    /**
     * 添加用户角色绑定
     * @param userId
     * @param roleId
     * @return
     */
    @Insert("insert into user_role values(#{userId},#{roleId});")
    int addUserRole(@Param("userId") Integer userId, @Param("roleId") Integer roleId);

    /**
     * 根据用户id除用户角色绑定
     * @param userId
     * @return
     */
    int delUserRoleByUserId(Integer userId);

    /**
     * 修改用户密码
     * @param user
     * @return
     */
    int updatePwd(User user);


}