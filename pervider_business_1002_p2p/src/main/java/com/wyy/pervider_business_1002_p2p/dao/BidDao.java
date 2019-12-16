package com.wyy.pervider_business_1002_p2p.dao;

import com.wyy.common_p2p.entity.borrowing.Bid;
import com.wyy.common_p2p.utils.Query;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;
import java.util.Map;

/**
 * (Bid)表数据库访问层
 *
 * @author cpc
 * @since 2019-10-31 14:03:42
 */
@Mapper
public interface BidDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Bid queryById(Integer id);

    /**
     * 通过query对象查询
     *
     * @param  query 分页查询对象 
     * @return 对象列表
     */
    List<Bid> queryPager(Query query);

    /**
     * 新增数据
     *
     * @param bid 实例对象
     * @return 影响行数
     */
    int insert(Bid bid);

    /**
     * 修改数据
     *
     * @param bid 实例对象
     * @return 影响行数
     */
    int update(Bid bid);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);


    /**
     * 这是根据借口表查找出所有投标
     * @param bidRequestId
     * @return
     */
    List<Bid> queryByRequestId(Integer bidRequestId);

    /**
     * 这是统计客户同投资了多少钱
     * @param membersId
     * @return
     */
    Integer  membersAvailableAmountSum(Integer membersId);


    List<Map> membersBidQueryPager(Query query);
}