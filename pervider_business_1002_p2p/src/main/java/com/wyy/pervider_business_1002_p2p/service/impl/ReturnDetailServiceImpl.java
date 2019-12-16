package com.wyy.pervider_business_1002_p2p.service.impl;

import com.wyy.common_p2p.entity.borrowing.ReturnDetail;
import com.wyy.common_p2p.utils.Query;
import com.wyy.pervider_business_1002_p2p.dao.ReturnDetailDao;
import com.wyy.pervider_business_1002_p2p.service.ReturnDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("returnDetailService")
public class ReturnDetailServiceImpl implements ReturnDetailService {
    @Resource
    private ReturnDetailDao returnDetailDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ReturnDetail queryById(Integer id) {
        return this.returnDetailDao.queryById(id);
    }

    /**
     * 通过query对象查询
     *
     * @param  query 分页查询对象 
     * @return 对象列表
     */
    @Override
    public List<ReturnDetail> queryPager(Query query) {
        return this.returnDetailDao.queryPager(query);
    }

    /**
     * 新增数据
     *
     * @param returnDetail 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(ReturnDetail returnDetail) {
        return this.returnDetailDao.insert(returnDetail);
    }

    /**
     * 修改数据
     *
     * @param returnDetail 实例对象
     * @return 实例对象
     */
    @Override
    public int update(ReturnDetail returnDetail) {
        return this.returnDetailDao.update(returnDetail);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer id) {
        return this.returnDetailDao.deleteById(id);
    }
}