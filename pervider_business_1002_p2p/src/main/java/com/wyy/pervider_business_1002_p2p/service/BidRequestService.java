package com.wyy.pervider_business_1002_p2p.service;

import com.wyy.common_p2p.entity.borrowing.BidRequest;
import com.wyy.common_p2p.utils.Query;


import java.util.List;

public interface BidRequestService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BidRequest queryById(Integer id);

    /**
     * 查找出当前用户的借款项目
     * @param membersId
     * @return
     */
    BidRequest getCurrentBidRequest(Integer membersId);

    /**
     * 获取当前最大的id
     * @return
     */
    Integer getMaxId();

    /**
     * 新增数据
     *
     * @param bidRequest 实例对象
     * @return 添加行数
     */
     int insert(BidRequest bidRequest);

    /**
     * 通过query对象查询
     *
     * @param  query 分页查询对象 
     * @return 对象列表
     */
    List<BidRequest> queryPager(Query query);


    /**
     * 修改数据
     *
     * @param bidRequest 实例对象
     * @return 修改行数
     */
     int update(BidRequest bidRequest);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 删除行数
     */
    int deleteById(Integer id);


    /**
     * 借款失败 退钱
     * @param requestId
     */
    void failedPayment(Integer requestId);


}