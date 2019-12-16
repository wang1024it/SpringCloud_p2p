package com.wyy.pervider_business_1002_p2p.service;


import com.wyy.common_p2p.entity.borrowing.Bid;
import com.wyy.common_p2p.utils.Query;

import java.util.List;
import java.util.Map;

public interface BidService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Bid queryById(Integer id);


    /**
     * 新增数据
     *
     * @param bid 实例对象
     * @return 添加行数
     */
     int insert(Bid bid);

    /**
     * 通过query对象查询
     *
     * @param  query 分页查询对象 
     * @return 对象列表
     */
    List<Bid> queryPager(Query query);


    /**
     * 根据借款id查找出所有透白
     * @param bidRequestId
     * @return
     */
    List<Bid> queryByRequestId(Integer bidRequestId);


    /**
     * 修改数据
     *
     * @param bid 实例对象
     * @return 修改行数
     */
     int update(Bid bid);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 删除行数
     */
    int deleteById(Integer id);

    Map investmentCalculation(int currentMembersId);

    List<Map> membersBidQueryPager(Query query);
}