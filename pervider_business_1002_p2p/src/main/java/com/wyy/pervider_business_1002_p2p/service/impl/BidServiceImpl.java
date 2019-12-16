package com.wyy.pervider_business_1002_p2p.service.impl;

import com.wyy.common_p2p.entity.borrowing.Bid;
import com.wyy.common_p2p.utils.Query;
import com.wyy.pervider_business_1002_p2p.dao.BidDao;
import com.wyy.pervider_business_1002_p2p.dao.RefundDetailDao;
import com.wyy.pervider_business_1002_p2p.service.BidService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Bid)表服务实现类
 *
 * @author cpc
 * @since 2019-10-31 14:03:42
 */
@Service("bidService")
public class BidServiceImpl implements BidService {
    @Resource
    private BidDao bidDao;
    @Resource
    private RefundDetailDao refundDetailDao;

    @Override
    public Map investmentCalculation(int membersId) {
        Map map = new HashMap();
        map.put("membersAvailableAmountSum", this.bidDao.membersAvailableAmountSum(membersId));
        map.put("membersInterestSum", this.refundDetailDao.membersInterestSum(membersId));
        return map;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Bid queryById(Integer id) {
        return this.bidDao.queryById(id);
    }

    /**
     * 通过query对象查询
     *
     * @param  query 分页查询对象 
     * @return 对象列表
     */
    @Override
    public List<Bid> queryPager(Query query) {
        return this.bidDao.queryPager(query);
    }

    @Override
    public List<Bid> queryByRequestId(Integer requestId) {
        return this.bidDao.queryByRequestId(requestId);
    }

    /**
     * 新增数据
     *
     * @param bid 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Bid bid) {
        return this.bidDao.insert(bid);
    }

    /**
     * 修改数据
     *
     * @param bid 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Bid bid) {
        return this.bidDao.update(bid);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer id) {
        return this.bidDao.deleteById(id);
    }


    /**
     *用户投资管理查询
     * @param query
     * @return
     */
    @Override
    public List<Map> membersBidQueryPager(Query query){
        return this.bidDao.membersBidQueryPager(query);
    }
}