package com.wyy.pervider_sys_1004_p2p.service.impl;


import com.wyy.common_p2p.entity.sys.Sysdict;
import com.wyy.common_p2p.utils.Query;
import com.wyy.pervider_sys_1004_p2p.dao.SysdictDao;
import com.wyy.pervider_sys_1004_p2p.service.SysdictService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Sysdict)表服务实现类
 *
 * @author cpc
 * @since 2019-10-21 11:46:05
 */
@Service("sysdictService")
public class SysdictServiceImpl implements SysdictService {
    @Resource
    private SysdictDao sysdictDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Sysdict queryById(Integer id) {
        return this.sysdictDao.queryById(id);
    }

    /**
     * 通过query对象查询
     *
     * @param  query 分页查询对象 
     * @return 对象列表
     */
    @Override
    public List<Sysdict> queryPager(Query query) {
        return this.sysdictDao.queryPager(query);
    }

    /**
     * 新增数据
     *
     * @param sysdict 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Sysdict sysdict) {
        return this.sysdictDao.insert(sysdict);
    }

    /**
     * 修改数据
     *
     * @param sysdict 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Sysdict sysdict) {
        return this.sysdictDao.update(sysdict);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer id) {
        return this.sysdictDao.deleteById(id);
    }
}