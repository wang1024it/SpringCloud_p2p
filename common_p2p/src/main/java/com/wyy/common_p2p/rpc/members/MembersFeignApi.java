package com.wyy.common_p2p.rpc.members;

import com.wyy.common_p2p.entity.members.Members;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author: cpc
 * @Date: 2019-12-10 10:21
 * @Version: V1.0
 */
@FeignClient(value = "MEMBERS")//被调用方服务名
public interface MembersFeignApi {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @GetMapping("/members/queryById")
    Members queryById(Integer id);

    /**
     * 这是修改用户账户信息
     * @param members
     * @return
     */
    @RequestMapping("/members/update")
    public int update(Members members);
}
