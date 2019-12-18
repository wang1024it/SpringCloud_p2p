package com.wyy.pervider_user_1001_p2p.dao;


import com.wyy.common_p2p.entity.members.MembersMaterials;
import com.wyy.common_p2p.utils.Query;

import java.util.List;

/**
 * (MembersMaterials)表数据库访问层
 *
 * @author cpc
 * @since 2019-10-25 15:29:52
 */
public interface MembersMaterialsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MembersMaterials queryById(Integer id);

    /**
     * 通过query对象查询
     *
     * @param  query 分页查询对象 
     * @return 对象列表
     */
    List<MembersMaterials> queryPager(Query query);

    /**
     * 新增数据
     *
     * @param membersMaterials 实例对象
     * @return 影响行数
     */
    int insert(MembersMaterials membersMaterials);

    /**
     * 修改数据
     *
     * @param membersMaterials 实例对象
     * @return 影响行数
     */
    int update(MembersMaterials membersMaterials);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}