package com.wyy.pervider_sys_1004_p2p.service.impl;


import com.wyy.common_p2p.entity.setting.Setting;
import com.wyy.common_p2p.utils.Query;
import com.wyy.pervider_sys_1004_p2p.dao.SettingDao;
import com.wyy.pervider_sys_1004_p2p.service.SettingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Setting)表服务实现类
 *
 * @author cpc
 * @since 2019-10-22 21:16:54
 */
@Service("settingService")
public class SettingServiceImpl implements SettingService {
    @Resource
    private SettingDao settingDao;

    /**
     * 通过ID查询单条数据
     *
     * @param key 主键
     * @return 实例对象
     */
    @Override
    public Setting queryById(String key) {
        return this.settingDao.queryById(key);
    }

    /**
     * 通过query对象查询
     *
     * @param  query 分页查询对象 
     * @return 对象列表
     */
    @Override
    public List<Setting> queryPager(Query query) {
        return this.settingDao.queryPager(query);
    }

    /**
     * 新增数据
     * @param key
     * @param useableminlimit
     * @return
     */
    @Override
    public int insert(String key,Object useableminlimit) {
        return this.settingDao.insert(key,useableminlimit);
    }

    /**
     * 修改数据
     * @param key
     * @param useableminlimit
     * @return
     */
    @Override
    public int update(String key,Object useableminlimit) {
        return this.settingDao.update(key,useableminlimit + "");
    }

    /**
     * 通过主键删除数据
     *
     * @param key 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(String key) {
        return this.settingDao.deleteById(key);
    }


}