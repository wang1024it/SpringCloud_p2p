package com.wyy.pervider_shiro_1006_p2p.controller;

import com.wyy.common_p2p.entity.sys.Menu;
import com.wyy.common_p2p.entity.sys.Permission;
import com.wyy.common_p2p.utils.JwtSession;
import com.wyy.common_p2p.utils.PageUtils;
import com.wyy.common_p2p.utils.Query;
import com.wyy.common_p2p.utils.R;
import com.wyy.pervider_shiro_1006_p2p.service.PermissionService;
import com.wyy.pervider_shiro_1006_p2p.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * (Permission)表控制层
 *
 * @author cpc
 * @since 2019-10-19 21:18:15
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {
    /**
     *
     * 服务对象
     */
    @Resource
    private PermissionService permissionService;


    /**
     * 用户请求对象
     */
    @Resource
    private UserService userService;


    /**
     * 获取用户菜单页
     * @param request
     * @return
     */
    @GetMapping("queryUserMenu")
    public List<Menu> queryUserMenu(HttpServletRequest request) {
        return permissionService.queryUserMenu(JwtSession.getCurrentUserId());
//        return permissionService.queryUserMenu(1);
    }


    /**
     * 分页查询
     *
     * @param  params 请求参数集
     * @return 结果集封装对象
     */
    @GetMapping("queryPager")
    public PageUtils queryPager(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<Permission> list = permissionService.queryPager(query);
        return new PageUtils(list, query.getTotal());
    }


    /**
     * 新增数据
     *
     * @param permission 实例对象
     * @return R
     */
    @PostMapping("add")
    public R add(Permission permission) {
        return R.update(permissionService.insert(permission));
    }



    /**
     * 修改数据
     *
     * @param permission 实例对象
     * @return R
     */
    @PostMapping("update")
    public R update(Permission permission) {
        return R.update(permissionService.update(permission));
    }

    /**
     * 删除数据
     *
     * @param perId 主键
     * @return R
     */
    @PostMapping("del")
    public  R del(Integer perId) {
        return R.update(permissionService.deleteById(perId));
    }


    /**
     *这是获取菜单的方法
     * @return
     */
    @GetMapping("getRoleModules")
    public List<Menu> getRoleModules(){

        return this.permissionService.queryModules();
    }
    /**
     * 根据角色id找到所有对应的权限id
     * @param roleId 角色Id
     * @return
     */
    @GetMapping("queryIdByRole")
    public List<Integer> queryIdByRole(Integer roleId){
        return this.permissionService.queryIdByRole(roleId);
    }
}