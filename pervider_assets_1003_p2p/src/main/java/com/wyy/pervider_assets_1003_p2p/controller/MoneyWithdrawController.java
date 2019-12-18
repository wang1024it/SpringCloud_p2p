package com.wyy.pervider_assets_1003_p2p.controller;


import com.wyy.common_p2p.entity.assets.MoneyWithdraw;
import com.wyy.common_p2p.utils.JwtSession;
import com.wyy.common_p2p.utils.PageUtils;
import com.wyy.common_p2p.utils.Query;
import com.wyy.common_p2p.utils.R;
import com.wyy.pervider_assets_1003_p2p.service.MoneyWithdrawService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * (MoneyWithdraw)表控制层   提现记录
 *
 * @author cpc
 * @since 2019-10-24 17:02:01
 */
@RestController
@RequestMapping("assets/moneyWithdraw")
public class MoneyWithdrawController {
    /**
     * 服务对象
     */
    @Resource
    private MoneyWithdrawService moneyWithdrawService;

    /**
     * 这是账户对象
     */
//    @Resource
//    private MembersAccountService membersAccountService;


    /**
     * 分页查询
     *
     * @param  params 请求参数集
     * @return 结果集封装对象 
     */
    @GetMapping("queryPager")
    public PageUtils queryPager(@RequestParam Map<String, Object> params) {
         Query query = new Query(params);
         List<MoneyWithdraw> list = moneyWithdrawService.queryPager(query);
         return new PageUtils(list, query.getTotal());
    }


    /**
     * 这是申请体现
     * @param moneyWithdraw
     * @return
     */
    @PostMapping("applicatio")
    public R applicatio(MoneyWithdraw moneyWithdraw){
        moneyWithdraw.setMembersId(JwtSession.getCurrentMembersId());
        moneyWithdraw.setApplyTime(new Date());
        return R.update(this.moneyWithdrawService.insert(moneyWithdraw));
    }

    /**
     *  用户提现操作，状态改为待审核
     * @param state
     * @return`
     */
    @PostMapping("updateState")
    public R updateState(MoneyWithdraw state){
        //记录
        //如果是提现成功
        if(state.getState() == 0){
            //将用户账户上的钱减掉
//            MembersAccount membersAccount = membersAccountService.queryByMembersId(JwtSession.getCurrentMembersId());
//            取的钱 + 手续费
//            membersAccount.setUsableAmount(membersAccount.getUsableAmount().subtract(state.getAmount().add(state.getFee())));
//            this.membersAccountService.update(membersAccount);
        }
        //执行修改
        return R.update(this.moneyWithdrawService.update(state));
    }
}