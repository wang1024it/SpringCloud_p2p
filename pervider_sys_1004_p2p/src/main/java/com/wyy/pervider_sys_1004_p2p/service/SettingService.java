package com.wyy.pervider_sys_1004_p2p.service;


import com.wyy.common_p2p.entity.setting.Setting;
import com.wyy.common_p2p.utils.Query;

import java.util.List;


/**
 * (Setting)表服务接口
 *
 * @author cpc
 * @since 2019-10-22 21:16:54
 */
public interface SettingService {

    /**
     * 通过ID查询单条数据
     *
     * @param key 主键
     * @return 实例对象
     */
    Setting queryById(String key);


    /**
     * 新增数据
     * @param key
     * @param useableminlimit
     * @return
     */
     int insert(String key, Object useableminlimit);

    /**
     * 通过query对象查询
     *
     * @param  query 分页查询对象 
     * @return 对象列表
     */
    List<Setting> queryPager(Query query);



    /**
     * 修改设置值
     * @param key
     * @param useableminlimit
     * @return
     */
     int update(String key, Object useableminlimit);

    /**
     * 通过主键删除数据
     *
     * @param key 主键
     * @return 删除行数
     */
    int deleteById(String key);



}