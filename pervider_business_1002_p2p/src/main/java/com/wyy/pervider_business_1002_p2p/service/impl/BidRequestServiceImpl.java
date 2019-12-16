package com.wyy.pervider_business_1002_p2p.service.impl;

import com.wyy.common_p2p.entity.borrowing.BidRequest;
import com.wyy.common_p2p.utils.Query;
import com.wyy.pervider_business_1002_p2p.dao.BidDao;
import com.wyy.pervider_business_1002_p2p.dao.BidRequestDao;
import com.wyy.pervider_business_1002_p2p.service.BidRequestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BidRequest)表服务实现类
 *
 * @author cpc
 * @since 2019-10-31 14:03:42
 */
@Service("bidRequestService")
public class BidRequestServiceImpl implements BidRequestService {
    @Resource
    private BidRequestDao bidRequestDao;

//    @Resource
//    private MembersAccountDao membersAccountDao;

    @Resource
    private BidDao bidDao;


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BidRequest queryById(Integer id) {
        return this.bidRequestDao.queryById(id);
    }

    @Override
    public BidRequest getCurrentBidRequest(Integer membersId) {
        return this.bidRequestDao.getCurrentBidRequest(membersId);
    }

    @Override
    public Integer getMaxId()
    {
        return this.bidRequestDao.getMaxId();
    }

    /**
     * 通过query对象查询
     *
     * @param  query 分页查询对象 
     * @return 对象列表
     */
    @Override
    public List<BidRequest> queryPager(Query query) {
        return this.bidRequestDao.queryPager(query);
    }

    /**
     * 新增数据
     *
     * @param bidRequest 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(BidRequest bidRequest) {
        return this.bidRequestDao.insert(bidRequest);
    }

    /**
     * 修改数据
     *
     * @param bidRequest 实例对象
     * @return 实例对象
     */
    @Override
    public int update(BidRequest bidRequest) {
        return this.bidRequestDao.update(bidRequest);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer id) {
        return this.bidRequestDao.deleteById(id);
    }

    /**
     * 这是付款失败
     * @param requestId
     */
    @Override
    public void failedPayment(Integer requestId) {
//        List<Bid> bids = bidDao.queryByRequestId(requestId);
//        //开始返款
//        if(bids != null && bids.size() > 0){
//            for(Bid bid: bids){
//                MembersAccount membersAccount = membersAccountDao.queryByMembersId(bid.getMembersId());
//                //回款
//                BigDecimal sum = membersAccount.getUsableAmount().add(bid.getAvailableAmount());
//                membersAccount.setUsableAmount(sum);
//                //修改客金额
//                this.membersAccountDao.update(membersAccount);
//            }
//
//        }
    }
}