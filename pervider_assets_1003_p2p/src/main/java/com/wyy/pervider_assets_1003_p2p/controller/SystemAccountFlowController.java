package com.wyy.pervider_assets_1003_p2p.controller;

import com.wyy.common_p2p.entity.assets.SystemAccountFlow;
import com.wyy.common_p2p.utils.PageUtils;
import com.wyy.common_p2p.utils.Query;
import com.wyy.common_p2p.utils.R;
import com.wyy.pervider_assets_1003_p2p.service.SystemAccountFlowService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (SystemAccountFlow)表控制层
 *
 * @author cpc
 * @since 2019-12-10 23:04:39
 */
@RestController
@RequestMapping("systemAccoutFlow")
public class SystemAccountFlowController {

    @Resource
    private SystemAccountFlowService systemAccountFlowService;

    /**
     * 分页查询
     *
     * @param  params 请求参数集
     * @return 结果集封装对象 
     */
    @GetMapping("queryPager")
    public PageUtils queryPager(@RequestParam Map<String, Object> params) {
         Query query = new Query(params);
         List<SystemAccountFlow> list = systemAccountFlowService.queryPager(query);
         return new PageUtils(list, query.getTotal());
    }
    
   
    /**
     * 新增数据
     *
     * @param systemAccountFlow 实例对象
     * @return R 
     */
    @PostMapping("add")
    public R add(SystemAccountFlow systemAccountFlow) {
        return R.update(systemAccountFlowService.insert(systemAccountFlow));
    }
    
    
    
    /**
     * 修改数据
     *
     * @param systemAccountFlow 实例对象
     * @return R 
     */
    @PostMapping("update")
    public  R update(SystemAccountFlow systemAccountFlow) {
        return R.update(systemAccountFlowService.update(systemAccountFlow));
    }
    
    /**
     * 删除数据
     *
     * @param id 主键
     * @return R 
     */
    @PostMapping("del")
    public  R del(Integer id) {
        return R.update(systemAccountFlowService.deleteById(id));
    }
}