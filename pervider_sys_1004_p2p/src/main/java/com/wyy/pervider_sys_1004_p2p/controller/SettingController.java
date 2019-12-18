package com.wyy.pervider_sys_1004_p2p.controller;


import com.wyy.common_p2p.entity.setting.Setting;
import com.wyy.common_p2p.utils.PageUtils;
import com.wyy.common_p2p.utils.Query;
import com.wyy.pervider_sys_1004_p2p.service.SettingService;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.security.Key;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * (Setting)表控制层
 *
 * @author cpc
 * @since 2019-10-22 21:16:54
 */
@RestController
@RequestMapping("setting/setting")
public class SettingController {
    /**
     * 服务对象
     */
    @Resource
    private SettingService settingService;



    /**
     * 分页查询
     *
     * @param  params 请求参数集
     * @return 结果集封装对象 
     */
    @GetMapping("queryPager")
    public PageUtils queryPager(@RequestParam Map<String, Object> params) {
         Query query = new Query(params);
         List<Setting> list = settingService.queryPager(query);
         return new PageUtils(list, query.getTotal());
    }


    /**
     * 查询到所有设置项，
     * @param key
     * @return
     */
    @GetMapping("query")
    public Setting query(String key){
        Setting setting = settingService.queryById(key);
        return new Setting();
    }

    /**
     * 更改设置，并存进redis
     * @param useableminlimit
     * @return
     */
    @PostMapping("setMinLimit")
    public int setMinLimit(String key,Object useableminlimit){
        return this.settingService.insert(key,useableminlimit);
    }



    

}