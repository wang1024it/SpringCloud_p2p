package com.wyy.pervider_shiro_1006_p2p.service.impl;

import com.wyy.common_p2p.entity.sys.Role;
import com.wyy.common_p2p.utils.Query;
import com.wyy.pervider_shiro_1006_p2p.dao.RoleDao;
import com.wyy.pervider_shiro_1006_p2p.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (Role)表服务实现类
 *
 * @author cpc
 * @since 2019-10-20 08:15:40
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleDao roleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param roleId 主键
     * @return 实例对象
     */
    @Override
    public Role queryById(Integer roleId) {
        return this.roleDao.queryById(roleId);
    }

    /**
     * 通过query对象查询
     *
     * @param  query 分页查询对象 
     * @return 对象列表
     */
    @Override
    public List<Role> queryPager(Query query) {
        return this.roleDao.queryPager(query);
    }


    @Override
    public Role queryByCoding(String coding) {
        return this.roleDao.queryByCoding(coding);
    }

    @Override
    @Transactional
    public int insert(Role role, String permissionIds) {
        //添加角色
        return this.roleDao.insert(role);
    }

    @Override
    public int authorization(Integer roleId, String permissionIds) {
        //重新绑定角色权限
        this.roleDao.delRolePermissionByRoleId(roleId);

        if(permissionIds != null && permissionIds.length() > 0){
            //重新绑定
            String[] ids = permissionIds.split(",");
            for (int i = 0; i < ids.length; i++) {
                this.roleDao.addRolePermission(roleId, Integer.parseInt(ids[i]));
            }
        }
        return 1;
    }

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public int update(Role role,String permissionIds) {
        //修改当前角色
        return this.roleDao.update(role);
    }

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer roleId) {
        //删除角色的权限绑定数据
        this.roleDao.delRolePermissionByRoleId(roleId);
        return this.roleDao.deleteById(roleId);
    }

    @Override
    public Role queryByName(String roleName) {
        return this.roleDao.queryByName(roleName);
    }

    @Override
    public List<Map> getRoleSelect() {
        return this.roleDao.getRoleSelect();
    }

    @Override
    public int addRolePermission(Integer roleId, Integer perId) {
        return this.roleDao.addRolePermission(roleId, perId);
    }


}