package com.wyy.pervider_user_1001_p2p.service.impl;


import com.wyy.common_p2p.entity.members.Members;
import com.wyy.common_p2p.utils.Query;
import com.wyy.pervider_user_1001_p2p.dao.MembersDao;
import com.wyy.pervider_user_1001_p2p.service.MembersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Members)表服务实现类
 *
 * @author cpc
 * @since 2019-10-25 16:10:56
 */
@Service("membersService")
public class MembersServiceImpl implements MembersService {
    @Resource
    private MembersDao membersDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Members queryById(Integer id) {
        return this.membersDao.queryById(id);
    }

    @Override
    public Members login(Members mebers) {
        return this.membersDao.login(mebers);
    }

    /**
     * 通过query对象查询
     *
     * @param  query 分页查询对象 
     * @return 对象列表
     */
    @Override
    public List<Members> queryPager(Query query) {
        return this.membersDao.queryPager(query);
    }

    /**
     * 新增数据
     *
     * @param members 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Members members) {
        return this.membersDao.insert(members);
    }

    /**
     * 修改数据
     *
     * @param members 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Members members) {
        return this.membersDao.update(members);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer id) {
        return this.membersDao.deleteById(id);
    }

    @Override
    public Integer getMaxId() {
        return this.membersDao.getMaxId();
    }

    @Override
    public Integer initMembersDetail(Integer membersId) {
        return this.membersDao.initMembersDetail(membersId);
    }

    @Override
    public Integer initMembersAccount(Integer membersId) {
        return this.membersDao.initMembersAccount(membersId);
    }


}