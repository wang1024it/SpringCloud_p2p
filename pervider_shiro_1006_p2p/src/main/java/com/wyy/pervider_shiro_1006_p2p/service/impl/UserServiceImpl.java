package com.wyy.pervider_shiro_1006_p2p.service.impl;

import com.wyy.common_p2p.entity.sys.User;
import com.wyy.common_p2p.utils.Query;
import com.wyy.pervider_shiro_1006_p2p.dao.RoleDao;
import com.wyy.pervider_shiro_1006_p2p.dao.UserDao;
import com.wyy.pervider_shiro_1006_p2p.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * (User)表服务实现类
 *
 * @author cpc
 * @since 2019-10-19 17:34:51
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Resource
    private RoleDao roleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userid 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer userid) {
        return this.userDao.queryById(userid);
    }

    /**
     * 通过query对象查询
     *
     * @param  query 分页查询对象 
     * @return 对象列表
     */
    @Override
    public List<User> queryPager(Query query) {
         List<User> list = this.userDao.queryPager(query);
         //角色处理
        if(list != null){
            for (User user: list) {
                //找角色
                List<Map> maps = this.roleDao.getUserRole(user.getUserId());
                if(maps != null && maps.size() > 0){
                    List<Integer> roleIds = new ArrayList<>(maps.size());
                    //这是角色名字以 “,”拼接
                    StringBuilder roleNames = new StringBuilder();
                    for (Map map: maps) {
                        roleIds.add(Integer.parseInt(map.get("roleId").toString()));
                        roleNames.append("," + map.get("roleName").toString());
                    }
                    user.setRoleIds(roleIds);

                    user.setRoleNames(roleNames.substring(1));
                }
            }
        }
        return list;
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @param roleIds 角色id字符串
     * @return 实例对象
     */
    @Override
    public int insert(User user, String roleIds) {
        //添加用户对象
        System.out.println("我们的用户是："+user);
        this.userDao.insert(user);
        //获取用户id
        Integer userId = this.userDao.getMaxId();
        //用户角色绑定
        addUserRole(userId, roleIds);
        return 1;
    }


    /**
     * 添加用户角色绑定
     * @param userId
     * @param roleIds
     */
    private void addUserRole(Integer userId, String roleIds){
        if(roleIds != null && roleIds.length() > 0){
            String[] ids = roleIds.split(",");
            for (int i = 0; i < ids.length; i++) {
                //添加用户角色绑定
                this.userDao.addUserRole(userId, Integer.parseInt(ids [i]));
            }
        }
    }
    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public int update(User user, String roleIds) {
        this.userDao.update(user);
        //删除用户角色绑定
        this.userDao.delUserRoleByUserId(user.getUserId());
        //重置角色绑定
        addUserRole(user.getUserId(), roleIds);
        return 1;
    }


    /**
     * 通过主键删除数据
     *
     * @param userid 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer userid) {
        this.userDao.deleteById(userid);
        //删除角色绑定
        this.userDao.delUserRoleByUserId(userid);
        return 1;
    }

    @Override
    public Set<String> getPersByUserId(Integer userId) {
        return this.userDao.getPersByUserId(userId);
    }

    @Override
    public int updatePwd(User user) {
        return this.userDao.updatePwd(user);
    }

    @Override
    public User queryByName(String userName) {
        return this.userDao.queryByName(userName);
    }

    @Override
    public Set<String> getRolesByUserId(Integer userId) {
        return this.userDao.getRolesByUserId(userId);
    }
}