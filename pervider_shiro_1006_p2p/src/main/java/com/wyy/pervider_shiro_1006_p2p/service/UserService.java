package com.wyy.pervider_shiro_1006_p2p.service;
import com.wyy.common_p2p.entity.sys.User;
import com.wyy.common_p2p.utils.Query;

import java.util.List;
import java.util.Set;

/**
 * (User)表服务接口
 *
 * @author cpc
 * @since 2019-10-19 17:34:51
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param userid 主键
     * @return 实例对象
     */
    User queryById(Integer userid);


    /**
     * 新增数据
     *
     * @param user 实例对象
     * @param roleIds 角色id字符串
     * @return 实例对象
     */
    int insert(User user, String roleIds);

    /**
     * 通过query对象查询
     *
     * @param  query 分页查询对象 
     * @return 对象列表
     */
    List<User> queryPager(Query query);


    /**
     * 修改数据
     *
     * @param user 实例对象
     * @param roleIds 角色字符集
     * @return 实例对象
     */
    int update(User user, String roleIds);

    /**
     * 通过主键删除数据
     *
     * @param userid 主键
     * @return 修改数据行数
     */
    int deleteById(Integer userid);

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
     * 修改用户密码
     * @param user
     * @return
     */
    int updatePwd(User user);


}