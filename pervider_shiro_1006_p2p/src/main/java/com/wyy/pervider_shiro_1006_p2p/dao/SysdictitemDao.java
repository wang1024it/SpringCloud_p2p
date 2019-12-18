package com.wyy.pervider_shiro_1006_p2p.dao;

import com.wyy.common_p2p.entity.sys.Sysdictitem;
import com.wyy.common_p2p.utils.Query;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * (Sysdictitem)表数据库访问层
 *
 * @author cpc
 * @since 2019-10-21 11:47:44
 */
public interface SysdictitemDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Sysdictitem queryById(Integer id);

    /**
     * 通过query对象查询
     *
     * @param  query 分页查询对象
     * @return 对象列表
     */
    List<Sysdictitem> queryPager(Query query);

    /**
     * 新增数据
     *
     * @param sysdictitem 实例对象
     * @return 影响行数
     */
    int insert(Sysdictitem sysdictitem);

    /**
     * 修改数据
     *
     * @param sysdictitem 实例对象
     * @return 影响行数
     */
    int update(Sysdictitem sysdictitem);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);


    /**
     * 查询指定字典类被下的字典条目
     * @param sn 这是字典类被的英文编码
     * @return
     */
    public List<Map> getSelect(String sn);





    /**
     *在指定的字典类型下翻译指定 value 对应的文本值
     * @param sn 类型
     * @param key 文本
     * @return
     */
    public String  queryDictTextByKey(@Param("sn") String sn, @Param("key") String key);

}