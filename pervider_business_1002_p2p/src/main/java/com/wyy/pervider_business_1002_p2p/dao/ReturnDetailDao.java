package com.wyy.pervider_business_1002_p2p.dao;


import com.wyy.common_p2p.entity.borrowing.ReturnDetail;
import com.wyy.common_p2p.utils.Query;


import java.util.List;


public interface ReturnDetailDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ReturnDetail queryById(Integer id);

    /**
     * 通过query对象查询
     *
     * @param  query 分页查询对象 
     * @return 对象列表
     */
    List<ReturnDetail> queryPager(Query query);

    /**
     * 新增数据
     *
     * @param returnDetail 实例对象
     * @return 影响行数
     */
    int insert(ReturnDetail returnDetail);

    /**
     * 修改数据
     *
     * @param returnDetail 实例对象
     * @return 影响行数
     */
    int update(ReturnDetail returnDetail);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}