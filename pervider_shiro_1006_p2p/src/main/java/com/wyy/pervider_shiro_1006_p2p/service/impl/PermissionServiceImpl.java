package com.wyy.pervider_shiro_1006_p2p.service.impl;

import com.wyy.common_p2p.entity.sys.Menu;
import com.wyy.common_p2p.entity.sys.Permission;
import com.wyy.common_p2p.utils.Query;
import com.wyy.pervider_shiro_1006_p2p.dao.PermissionDao;
import com.wyy.pervider_shiro_1006_p2p.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Permission)表服务实现类
 *
 * @author cpc
 * @since 2019-10-19 21:18:15
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {
    @Resource
    private PermissionDao permissionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param perId 主键
     * @return 实例对象
     */
    @Override
    public Permission queryById(Integer perId) {
        return this.permissionDao.queryById(perId);
    }

    /**
     * 通过query对象查询
     *
     * @param  query 分页查询对象
     * @return 对象列表
     */
    @Override
    public List<Permission> queryPager(Query query) {
        return this.permissionDao.queryPager(query);
    }

    /**
     * 新增数据
     *
     * @param permission 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Permission permission) {
        return this.permissionDao.insert(permission);
    }

    /**
     * 修改数据
     *
     * @param permission 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Permission permission) {
        return this.permissionDao.update(permission);
    }

    /**
     * 通过主键删除数据
     *
     * @param perId 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer perId) {
        return this.permissionDao.deleteById(perId);
    }


    @Override
    public List<Menu> queryUserMenu(Integer userId) {
        //获取顶级节点
        List<Menu> list = this.permissionDao.queryChildern(-1, userId);
        if(list.size() > 0){
            list.forEach(menu ->{
                getChildern(menu, userId);
            });
        }
        return list;
    }

    /**
     * 递归获取用户子菜单
     * @param menu
     */
    private void getChildern(Menu menu, Integer userId){
        List<Menu> list = this.permissionDao.queryChildern(menu.getId(), userId);
        menu.setModules(list);
        //如果还有子菜单继续遍历
        if(list.size() > 0){
            list.forEach(m ->{
                getChildern(m, userId);
            });
        }
    }

    @Override
    public List<Menu> queryModules() {
        //获取顶级节点
        List<Menu> list = this.permissionDao.queryModules(-1);
        if(list.size() > 0){
            list.forEach(menu ->{
                getModules(menu);
            });
        }
        return list;
    }

    /**
     * 这是将子菜单遍历出来
     * @param menu
     */
    private void getModules(Menu menu){
        List<Menu> list = this.permissionDao.queryModules(menu.getId());
        menu.setModules(list);
        //如果还有子菜单继续遍历
        if(list.size() > 0){
            list.forEach(m ->{
               getModules(m);
            });
        }
    }


    @Override
    public List<Integer> queryIdByRole(Integer roleId) {
        List<Integer> lsit = this.permissionDao.queryIdByRole(roleId);
        return this.permissionDao.queryIdByRole(roleId);
    }
}