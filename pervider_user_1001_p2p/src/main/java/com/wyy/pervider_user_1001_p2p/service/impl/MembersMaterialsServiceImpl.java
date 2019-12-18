package com.wyy.pervider_user_1001_p2p.service.impl;

import com.wyy.common_p2p.entity.members.MembersMaterials;
import com.wyy.common_p2p.utils.Query;
import com.wyy.pervider_user_1001_p2p.dao.MembersMaterialsDao;
import com.wyy.pervider_user_1001_p2p.service.MembersMaterialsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MembersMaterials)表服务实现类
 *
 * @author cpc
 * @since 2019-10-25 15:29:52
 */
@Service("membersMaterialsService")
public class MembersMaterialsServiceImpl implements MembersMaterialsService {
    @Resource
    private MembersMaterialsDao membersMaterialsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public MembersMaterials queryById(Integer id) {
        return this.membersMaterialsDao.queryById(id);
    }

    /**
     * 通过query对象查询
     *
     * @param  query 分页查询对象 
     * @return 对象列表
     */
    @Override
    public List<MembersMaterials> queryPager(Query query) {
        return this.membersMaterialsDao.queryPager(query);
    }

    /**
     * 新增数据
     *
     * @param membersMaterials 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(MembersMaterials membersMaterials) {
        return this.membersMaterialsDao.insert(membersMaterials);
    }

    /**
     * 修改数据
     *
     * @param membersMaterials 实例对象
     * @return 实例对象
     */
    @Override
    public int update(MembersMaterials membersMaterials) {
        return this.membersMaterialsDao.update(membersMaterials);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer id) {
        return this.membersMaterialsDao.deleteById(id);
    }
}