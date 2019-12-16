package com.wyy.pervider_business_1002_p2p.dao;


import com.wyy.common_p2p.entity.borrowing.RefundDetail;
import com.wyy.common_p2p.utils.Query;


import java.util.List;


public interface RefundDetailDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RefundDetail queryById(Integer id);

    /**
     * 通过query对象查询
     *
     * @param  query 分页查询对象 
     * @return 对象列表
     */
    List<RefundDetail> queryPager(Query query);

    /**
     * 新增数据
     *
     * @param refundDetail 实例对象
     * @return 影响行数
     */
    int insert(RefundDetail refundDetail);

    /**
     * 修改数据
     *
     * @param refundDetail 实例对象
     * @return 影响行数
     */
    int update(RefundDetail refundDetail);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);


    /**
     * 这是计算会员投标累计收益
     * @param membersId
     * @return
     */
    Integer membersInterestSum(Integer membersId);
}