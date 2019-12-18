package com.wyy.pervider_shiro_1006_p2p.controller;

import com.wyy.common_p2p.entity.sys.Sysdict;
import com.wyy.common_p2p.utils.PageUtils;
import com.wyy.common_p2p.utils.Query;
import com.wyy.common_p2p.utils.R;
import com.wyy.pervider_shiro_1006_p2p.service.SysdictService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 字典分类表 表控制层
 *
 * @author cpc
 * @since 2019-10-21 11:46:05
 */
@RestController
@RequestMapping("/dict")
public class SysdictController {
    /**
     * 服务对象
     */
    @Resource
    private SysdictService sysdictService;

    /**
     * 分页查询
     *
     * @param  params 请求参数集
     * @return 结果集封装对象
     */
    @GetMapping("queryPager")
    public PageUtils queryPager(@RequestParam Map<String, Object> params) {
         Query query = new Query(params);
         List<Sysdict> list = sysdictService.queryPager(query);
         return new PageUtils(list, query.getTotal());
    }


    /**
     * 添加字典分类
     * @param sysdict
     * @return
     */
    @PostMapping("add")
    public R add(Sysdict sysdict){
        return R.update(this.sysdictService.insert(sysdict));
    }


    /**
     * 删除字典分类
     * @param id
     * @return
     */
    @PostMapping("del/{id}")
    public R del(@PathVariable("id") Integer id){
        return R.update(this.sysdictService.deleteById(id));
    }


    /**
     * 修改字典分类
     * @param sysdict
     * @return
     */
    @PostMapping("/update")
    public R update(Sysdict sysdict){
        return R.update(this.sysdictService.update(sysdict));
    }



}