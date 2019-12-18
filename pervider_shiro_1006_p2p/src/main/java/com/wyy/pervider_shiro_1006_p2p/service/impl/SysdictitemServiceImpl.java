package com.wyy.pervider_shiro_1006_p2p.service.impl;

import com.wyy.common_p2p.entity.sys.Sysdictitem;
import com.wyy.common_p2p.utils.Query;
import com.wyy.pervider_shiro_1006_p2p.dao.SysdictitemDao;
import com.wyy.pervider_shiro_1006_p2p.service.SysdictitemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (Sysdictitem)表服务实现类
 *
 * @author cpc
 * @since 2019-10-21 11:47:44
 */
@Service("sysdictitemService")
public class SysdictitemServiceImpl implements SysdictitemService {
    @Resource
    private SysdictitemDao sysdictitemDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Sysdictitem queryById(Integer id) {
        return this.sysdictitemDao.queryById(id);
    }

    /**
     * 通过query对象查询
     *
     * @param  query 分页查询对象 
     * @return 对象列表
     */
    @Override
    public List<Sysdictitem> queryPager(Query query) {
        return this.sysdictitemDao.queryPager(query);
    }

    /**
     * 新增数据
     *
     * @param sysdictitem 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Sysdictitem sysdictitem) {
        return this.sysdictitemDao.insert(sysdictitem);
    }

    /**
     * 修改数据
     *
     * @param sysdictitem 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Sysdictitem sysdictitem) {
        return this.sysdictitemDao.update(sysdictitem);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer id) {
        return this.sysdictitemDao.deleteById(id);
    }

    @Override
    public List<Map> getSelect(String sn) {
        return this.sysdictitemDao.getSelect(sn);
    }

    @Override
    public String queryDictTextByKey(String sn, String key) {
        return this.sysdictitemDao.queryDictTextByKey(sn, key);
    }
}