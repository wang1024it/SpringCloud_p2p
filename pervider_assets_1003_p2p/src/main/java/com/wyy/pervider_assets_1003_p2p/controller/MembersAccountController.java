package com.wyy.pervider_assets_1003_p2p.controller;

import com.wyy.common_p2p.entity.assets.MembersAccount;
import com.wyy.common_p2p.utils.JwtSession;
import com.wyy.common_p2p.utils.PageUtils;
import com.wyy.common_p2p.utils.Query;
import com.wyy.common_p2p.utils.R;
import com.wyy.pervider_assets_1003_p2p.service.MembersAccountService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/account")
public class MembersAccountController {

    /**
     * 服务对象
     */
    @Resource
    private MembersAccountService membersAccountService;

    /**
     * 分页查询
     *
     * @param  params 请求参数集
     * @return 结果集封装对象
     *
     * req.getParamMap()
     *
     */
    @GetMapping("/queryPager")
    public PageUtils queryPager(@RequestParam Map<String, Object> params) {
         Query query = new Query(params);
         List<MembersAccount> list = membersAccountService.queryPager(query);
         return new PageUtils(list, query.getTotal());
    }

    /**
     * 单个查询
     * @param id
     * @return
     */
    @GetMapping("queryById")
    public MembersAccount queryById(Integer id){
        return this.membersAccountService.queryById(id);
    }

    /**
     * 修改字段项
     * @param membersAccount
     * @return
     */
    @PostMapping("update")
    public R update(MembersAccount membersAccount){
        return R.update(this.membersAccountService.update(membersAccount));
    }


    /**
     * 这是用户首页统计
     * @return
     */
    @GetMapping("myHomeStatistics")
    public R myHomeStatistics(){
        R r = R.ok();
        r.put("data", this.membersAccountService.myHomeStatistics(JwtSession.getCurrentMembersId()));
        return  r;
    }

    /**
     * 获取当前用户的账户
     * @return
     */
    @GetMapping("getCurrentMembersAccount")
    public MembersAccount getCurrentMembersAccount(){
        Query query = new Query();
        query.put("membersId", JwtSession.getCurrentMembersId());
        List<MembersAccount> list = membersAccountService.queryPager(query);
        return list.get(0);
    }


    /**
     * 这是根据 用户id查询到 用户对应的账户
     * @param membersId
     * @return
     */
    @RequestMapping("queryByMembersId")
    public MembersAccount queryByMembersId(Integer membersId){
        return membersAccountService.queryByMembersId(membersId);

    }
    /**
     * 这是根据 用户id查询到 用户对应的账户
     * @param membersId
     * @return
     */
    @RequestMapping("aa")
    public String aa(Integer membersId){
        return "aaaa";

    }

}