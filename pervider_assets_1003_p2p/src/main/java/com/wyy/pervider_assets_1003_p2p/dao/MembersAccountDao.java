package com.wyy.pervider_assets_1003_p2p.dao;


import com.wyy.common_p2p.entity.assets.MembersAccount;
import com.wyy.common_p2p.utils.Query;

import java.util.List;

/**
 * (MembersAccount)表数据库访问层
 *
 * @author cpc
 * @since 2019-10-26 16:31:44
 */
public interface MembersAccountDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MembersAccount queryById(Integer id);


    /**
     * 这是根据会员id查单个
     * @param membersId
     * @return
     */
    MembersAccount queryByMembersId(Integer membersId);


    /**
     * 通过query对象查询
     *
     * @param  query 分页查询对象 
     * @return 对象列表
     */
    List<MembersAccount> queryPager(Query query);

    /**
     * 新增数据
     *
     * @param membersAccount 实例对象
     * @return 影响行数
     */
    int insert(MembersAccount membersAccount);

    /**
     * 修改数据
     *
     * @param membersAccount 实例对象
     * @return 影响行数
     */
    int update(MembersAccount membersAccount);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}