package com.wyy.pervider_assets_1003_p2p.service.impl;


import com.wyy.common_p2p.entity.assets.MoneyWithdraw;
import com.wyy.common_p2p.utils.Query;
import com.wyy.pervider_assets_1003_p2p.dao.MoneyWithdrawDao;
import com.wyy.pervider_assets_1003_p2p.service.MoneyWithdrawService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MoneyWithdraw)表服务实现类
 *
 * @author cpc
 * @since 2019-10-24 17:02:01
 */
@Service("moneyWithdrawService")
public class MoneyWithdrawServiceImpl implements MoneyWithdrawService {
    @Resource
    private MoneyWithdrawDao moneyWithdrawDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public MoneyWithdraw queryById(Integer id) {
        return this.moneyWithdrawDao.queryById(id);
    }

    /**
     * 通过query对象查询
     *
     * @param  query 分页查询对象 
     * @return 对象列表
     */
    @Override
       public List<MoneyWithdraw> queryPager(Query query) {
        return this.moneyWithdrawDao.queryPager(query);
    }

    /**
     * 新增数据
     *
     * @param moneyWithdraw 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(MoneyWithdraw moneyWithdraw) {
        return this.moneyWithdrawDao.insert(moneyWithdraw);
    }

    /**
     * 修改数据
     *
     * @param moneyWithdraw 实例对象
     * @return 实例对象
     */
    @Override
    public int update(MoneyWithdraw moneyWithdraw) {
        return this.moneyWithdrawDao.update(moneyWithdraw);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer id) {
        return this.moneyWithdrawDao.deleteById(id);
    }
}