package com.wyy.pervider_assets_1003_p2p.service.impl;

import com.wyy.common_p2p.entity.assets.MembersAccount;
import com.wyy.common_p2p.entity.assets.MoneyRecharge;
import com.wyy.common_p2p.utils.Query;
import com.wyy.pervider_assets_1003_p2p.dao.MoneyRechargeDao;
import com.wyy.pervider_assets_1003_p2p.service.MoneyRechargeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MoneyRecharge)表服务实现类
 *
 * @author cpc
 * @since 2019-10-24 19:12:17
 */
@Service("moneyRechargeService")
public class MoneyRechargeServiceImpl implements MoneyRechargeService {
    @Resource
    private MoneyRechargeDao moneyRechargeDao;

//    @Resource
//    private MembersAccountDao membersAccountDao;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public MoneyRecharge queryById(Integer id) {
        return this.moneyRechargeDao.queryById(id);
    }

    /**
     * 通过query对象查询
     *
     * @param  query 分页查询对象 
     * @return 对象列表
     */
    @Override
    public List<MoneyRecharge> queryPager(Query query) {
        return this.moneyRechargeDao.queryPager(query);
    }

    /**
     * 新增数据
     *
     * @param moneyRecharge 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(MoneyRecharge moneyRecharge) {
        return this.moneyRechargeDao.insert(moneyRecharge);
    }

    /**
     * 修改数据
     *
     * @param moneyRecharge 实例对象
     * @return 实例对象
     */
    @Override
    public int update(MoneyRecharge moneyRecharge) {
        return this.moneyRechargeDao.update(moneyRecharge);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer id) {
        return this.moneyRechargeDao.deleteById(id);
    }

    /**
     * 向会员账户余额表和充值记录表插入数据
     * @param membersAccount
     * @param moneyRecharge
     * @return
     */
    @Override
    public int updateAmount(MembersAccount membersAccount, MoneyRecharge moneyRecharge){
//        this.membersAccountDao.update(membersAccount);
        this.moneyRechargeDao.update(moneyRecharge);
        return 1;
    }

}