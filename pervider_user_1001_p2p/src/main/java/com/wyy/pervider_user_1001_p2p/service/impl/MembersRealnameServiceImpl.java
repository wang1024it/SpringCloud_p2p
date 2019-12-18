package com.wyy.pervider_user_1001_p2p.service.impl;

import com.wyy.common_p2p.entity.members.MembersRealname;
import com.wyy.common_p2p.utils.Query;
import com.wyy.pervider_user_1001_p2p.dao.MembersRealnameDao;
import com.wyy.pervider_user_1001_p2p.service.MembersRealnameService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MembersRealname)表服务实现类
 *
 * @author cpc
 * @since 2019-10-23 15:51:06
 */
@Service("membersRealnameService")
public class MembersRealnameServiceImpl implements MembersRealnameService {
    @Resource
    private MembersRealnameDao membersRealnameDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public MembersRealname queryById(Integer id) {
        return this.membersRealnameDao.queryById(id);
    }

    /**
     * 通过query对象查询
     *
     * @param  query 分页查询对象 
     * @return 对象列表
     */
    @Override
    public List<MembersRealname> queryPager(Query query) {
        return this.membersRealnameDao.queryPager(query);
    }

    /**
     * 新增数据
     *
     * @param membersRealname 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(MembersRealname membersRealname) {
        return this.membersRealnameDao.insert(membersRealname);
    }

    /**
     * 修改数据
     *
     * @param membersRealname 实例对象
     * @return 实例对象
     */
    @Override
    public int update(MembersRealname membersRealname) {
        return this.membersRealnameDao.update(membersRealname);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer id) {
        return this.membersRealnameDao.deleteById(id);
    }


    /**
     * 修改状态
     * @param state
     * @return
     */
    @Override
    public int Changestatus(Integer state) {return this.membersRealnameDao.Changestatus(state);}


}