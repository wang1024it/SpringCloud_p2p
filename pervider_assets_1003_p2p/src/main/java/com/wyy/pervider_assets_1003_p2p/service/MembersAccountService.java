package com.wyy.pervider_assets_1003_p2p.service;


import com.wyy.common_p2p.entity.assets.MembersAccount;
import com.wyy.common_p2p.utils.Query;

import java.util.List;
import java.util.Map;

/**
 * (MembersAccount)表服务接口
 *
 * @author cpc
 * @since 2019-10-26 16:31:44
 */
public interface MembersAccountService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MembersAccount queryById(Integer id);


    MembersAccount queryByMembersId(Integer MembersId);

    /**
     * 新增数据
     *
     * @param membersAccount 实例对象
     * @return 添加行数
     */
     int insert(MembersAccount membersAccount);

    /**
     * 通过query对象查询
     *
     * @param  query 分页查询对象 
     * @return 对象列表
     */
    List<MembersAccount> queryPager(Query query);


    /**
     * 修改数据
     *
     * @param membersAccount 实例对象
     * @return 修改行数
     */
     int update(MembersAccount membersAccount);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 删除行数
     */
    int deleteById(Integer id);




    /**
     * 这是用户首页统计
     * @return
     */
    public Map myHomeStatistics(Integer membersId);



}