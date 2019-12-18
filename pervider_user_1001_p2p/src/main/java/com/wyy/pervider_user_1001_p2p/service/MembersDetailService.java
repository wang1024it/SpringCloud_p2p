package com.wyy.pervider_user_1001_p2p.service;


import com.wyy.common_p2p.entity.members.MembersDetail;
import com.wyy.common_p2p.utils.Query;

import java.util.List;

/**
 * (MembersDetail)表服务接口
 *
 * @author cpc
 * @since 2019-10-26 16:09:20
 */
public interface MembersDetailService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MembersDetail queryById(Integer id);


    /**
     * 新增数据
     *
     * @param membersDetail 实例对象
     * @return 添加行数
     */
     int insert(MembersDetail membersDetail);

    /**
     * 通过query对象查询
     *
     * @param  query 分页查询对象 
     * @return 对象列表
     */
    List<MembersDetail> queryPager(Query query);


    /**
     * 修改数据
     *
     * @param membersDetail 实例对象
     * @return 修改行数
     */
     int update(MembersDetail membersDetail);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 删除行数
     */
    int deleteById(Integer id);

}