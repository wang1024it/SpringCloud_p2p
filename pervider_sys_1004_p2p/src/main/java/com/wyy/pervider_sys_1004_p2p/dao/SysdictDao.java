package com.wyy.pervider_sys_1004_p2p.dao;



import com.wyy.common_p2p.entity.sys.Sysdict;
import com.wyy.common_p2p.utils.Query;

import java.util.List;

/**
 * (Sysdict)表数据库访问层
 *
 * @author cpc
 * @since 2019-10-21 11:46:05
 */
public interface SysdictDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Sysdict queryById(Integer id);

    /**
     * 通过query对象查询
     *
     * @param  query 分页查询对象 
     * @return 对象列表
     */
    List<Sysdict> queryPager(Query query);

    /**
     * 新增数据
     *
     * @param sysdict 实例对象
     * @return 影响行数
     */
    int insert(Sysdict sysdict);

    /**
     * 修改数据
     *
     * @param sysdict 实例对象
     * @return 影响行数
     */
    int update(Sysdict sysdict);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}