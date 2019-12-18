package com.wyy.pervider_assets_1003_p2p.service.impl;


import com.wyy.common_p2p.entity.assets.SystemAccountFlow;
import com.wyy.common_p2p.utils.Query;
import com.wyy.pervider_assets_1003_p2p.dao.SystemAccountFlowDao;
import com.wyy.pervider_assets_1003_p2p.service.SystemAccountFlowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SystemAccountFlow)表服务实现类
 *
 * @author cpc
 * @since 2019-12-10 23:04:39
 */
@Service("systemAccountFlowService")
public class SystemAccountFlowServiceImpl implements SystemAccountFlowService {
    @Resource
    private SystemAccountFlowDao systemAccountFlowDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SystemAccountFlow queryById(Integer id) {
        return this.systemAccountFlowDao.queryById(id);
    }

    /**
     * 通过query对象查询
     *
     * @param  query 分页查询对象 
     * @return 对象列表
     */
    @Override
    public List<SystemAccountFlow> queryPager(Query query) {
        return this.systemAccountFlowDao.queryPager(query);
    }

    /**
     * 新增数据
     *
     * @param systemAccountFlow 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(SystemAccountFlow systemAccountFlow) {
        return this.systemAccountFlowDao.insert(systemAccountFlow);
    }

    /**
     * 修改数据
     *
     * @param systemAccountFlow 实例对象
     * @return 实例对象
     */
    @Override
    public int update(SystemAccountFlow systemAccountFlow) {
        return this.systemAccountFlowDao.update(systemAccountFlow);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer id) {
        return this.systemAccountFlowDao.deleteById(id);
    }
}