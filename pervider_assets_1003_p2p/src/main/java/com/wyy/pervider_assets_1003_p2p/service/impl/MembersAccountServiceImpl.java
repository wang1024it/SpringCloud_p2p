package com.wyy.pervider_assets_1003_p2p.service.impl;

import com.wyy.common_p2p.entity.assets.MembersAccount;
import com.wyy.common_p2p.utils.Query;
import com.wyy.pervider_assets_1003_p2p.dao.MembersAccountDao;
import com.wyy.pervider_assets_1003_p2p.service.MembersAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (MembersAccount)表服务实现类
 *
 * @author cpc
 * @since 2019-10-26 16:31:44
 */
@Service("membersAccountService")
public class MembersAccountServiceImpl implements MembersAccountService {
    @Resource
    private MembersAccountDao membersAccountDao;
//    @Resource
//    private RefundDetailDao refundDetailDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public MembersAccount queryById(Integer id) {
        return this.membersAccountDao.queryById(id);
    }

    @Override
    public MembersAccount queryByMembersId(Integer MembersId) {
        return this.membersAccountDao.queryByMembersId(MembersId);
    }

    /**
     * 通过query对象查询
     *
     * @param  query 分页查询对象 
     * @return 对象列表
     */
    @Override
    public List<MembersAccount> queryPager(Query query) {
        return this.membersAccountDao.queryPager(query);
    }

    /**
     * 新增数据
     *
     * @param membersAccount 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(MembersAccount membersAccount) {
        return this.membersAccountDao.insert(membersAccount);
    }

    /**
     * 修改数据
     *
     * @param membersAccount 实例对象
     * @return 实例对象
     */
    @Override
    public int update(MembersAccount membersAccount) {
        return this.membersAccountDao.update(membersAccount);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer id) {
        return this.membersAccountDao.deleteById(id);
    }


    @Override
    public Map myHomeStatistics(Integer membersId) {
        Map map = new HashMap();
        //这是根据会员id查找出账户信息 
        MembersAccount membersAccount = this.membersAccountDao.queryByMembersId(membersId);
        //累计收益
//        map.put("membersInterestSum", this.refundDetailDao.membersInterestSum(membersId));
        //账户余额
        map.put("usableAmount", membersAccount.getUsableAmount());
        //代收本金
        map.put("unReceivePrincipal", membersAccount.getUnReceivePrincipal());
        //代收利息
        map.put("unReceiveInterest", membersAccount.getUnReceiveInterest());
        //授信额度
        map.put("borrowLimit", membersAccount.getBorrowLimit());
        return map;
    }
}