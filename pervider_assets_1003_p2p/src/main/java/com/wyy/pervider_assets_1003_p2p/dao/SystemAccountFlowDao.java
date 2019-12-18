package com.wyy.pervider_assets_1003_p2p.dao;


import com.wyy.common_p2p.entity.assets.SystemAccountFlow;
import com.wyy.common_p2p.utils.Query;

import java.util.List;

/**
 * (SystemAccountFlow)表数据库访问层
 *
 * @author cpc
 * @since 2019-12-10 23:04:39
 */
public interface SystemAccountFlowDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SystemAccountFlow queryById(Integer id);

    /**
     * 通过query对象查询
     *
     * @param  query 分页查询对象 
     * @return 对象列表
     */
    List<SystemAccountFlow> queryPager(Query query);

    /**
     * 新增数据
     *
     * @param systemAccountFlow 实例对象
     * @return 影响行数
     */
    int insert(SystemAccountFlow systemAccountFlow);

    /**
     * 修改数据
     *
     * @param systemAccountFlow 实例对象
     * @return 影响行数
     */
    int update(SystemAccountFlow systemAccountFlow);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}