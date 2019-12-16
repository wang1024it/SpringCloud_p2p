package com.wyy.common_p2p.rpc.assets;

import com.wyy.common_p2p.entity.assets.MembersAccount;
import com.wyy.common_p2p.utils.PageUtils;
import com.wyy.common_p2p.utils.R;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @Description:
 * @Author: cpc
 * @Date: 2019-12-10 9:07
 * @Version: V1.0
 */
@FeignClient(value = "ASSETS")//被调用方服务名
public interface MembersAccountFeignApi {

    /**
     * 分页查询
     *
     * @param  params 请求参数集
     * @return 结果集封装对象
     */
    @GetMapping("/account/queryPager")
    PageUtils queryPager(@RequestParam Map<String, Object> params);

    /**
     * 单个查询
     * @param id
     * @return
     */
    @GetMapping("/account/queryById")
    MembersAccount queryById(Integer id);

    /**
     * 修改字段项
     * @param membersAccount
     * @return
     */
    @PostMapping("/account/update")
    R update(MembersAccount membersAccount);

    /**
     * 这是用户首页统计
     * @return
     */
    @GetMapping("/account/myHomeStatistics")
    public R myHomeStatistics();

    /**
     * 获取当前用户的账户
     * @return
     */
    @GetMapping("/account/getCurrentMembersAccount")
    MembersAccount getCurrentMembersAccount();


    /**
     * 这是根据会员id查找出 用户账户对象
     * @param membersId
     * @return
     */
    @RequestMapping("/account/queryByMembersId")
    MembersAccount queryByMembersId(Integer membersId);

}
