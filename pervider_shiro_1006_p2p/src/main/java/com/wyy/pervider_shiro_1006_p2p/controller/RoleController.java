package com.wyy.pervider_shiro_1006_p2p.controller;

import com.wyy.common_p2p.entity.sys.Role;
import com.wyy.common_p2p.utils.PageUtils;
import com.wyy.common_p2p.utils.Query;
import com.wyy.common_p2p.utils.R;
import com.wyy.pervider_shiro_1006_p2p.service.RoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * (Role)表控制层
 *
 * @author cpc
 * @since 2019-10-20 08:15:40
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    /**
     * 服务对象
     */
    @Resource
    private RoleService roleService;

    /**
     * 通过query对象查询
     *
     * @param params
     * @return 对象列表
     *
     * */
    @GetMapping("queryPager")
    public PageUtils queryPager(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<Role> list = this.roleService.queryPager(query);
        return new PageUtils(list, query.getTotal());
    }


    /**
     * 添加角色
     * @param role
     * @param permissionIds
     * @return
     */
    @PostMapping("add")
    public R add(Role role, String permissionIds){
        //判断角色是否重名
        if(this.roleService.queryByName(role.getRoleName()) != null) {
            return R.error("角色名重复!!");
        }
        //判断角色编码是否重复
        if(this.roleService.queryByCoding(role.getRoleCoding()) != null){
            return R.error("角色编码重复!!");
        }
        //设置创建时间
        role.setCreationTime(new Date());
        return R.update(this.roleService.insert(role, permissionIds));
    }


    /**
     * 修改角色
     * @param role
     * @return
     */
    @PostMapping("update")
    public R update(Role role,String permissionIds){
        //找到数据库中对应的角色名
        Role r = this.roleService.queryById(role.getRoleId());
        //判断角色是否重名
        if(this.roleService.queryByName(role.getRoleName()) != null && !r.getRoleName().equals(role.getRoleName())) {
            return R.error("角色名重复!!");
        }
        //判断角色编码是否重复
        if(this.roleService.queryByCoding(role.getRoleCoding()) != null && !r.getRoleCoding().equals(role.getRoleCoding())){
            return R.error("角色编码重复!!");
        }

        //设置修购时间
        role.setUpdateTime(new Date());
        return R.update(this.roleService.update(role, permissionIds));
    }


    /**
     * 获取角色下拉
     * @return
     */
    @GetMapping("getRoleSelect")
    public List<Map> getRoleSelect(){
        return this.roleService.getRoleSelect();
    }

    /**
     * 删除角色
     * @return
     */
    @PostMapping("del/{roleId}")
    public R del(@PathVariable("roleId") Integer roleId){
        return R.update(this.roleService.deleteById(roleId));
    }

    /**
     * 角色授权
     * @param roleId
     * @param permissionIds
     * @return
     */
    @PostMapping("authorization")
    public R authorization(Integer roleId, String permissionIds){
        return R.update(this.roleService.authorization(roleId, permissionIds));
    }
}