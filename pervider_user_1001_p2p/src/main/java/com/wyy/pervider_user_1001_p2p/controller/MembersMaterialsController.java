package com.wyy.pervider_user_1001_p2p.controller;


import com.wyy.common_p2p.entity.members.MembersMaterials;
import com.wyy.common_p2p.utils.PageUtils;
import com.wyy.common_p2p.utils.Query;
import com.wyy.common_p2p.utils.R;
import com.wyy.pervider_user_1001_p2p.service.MembersMaterialsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (MembersMaterials)表控制层
 *
 * @author cpc
 * @since 2019-10-25 15:29:52
 */
@RestController
@RequestMapping("membersMaterials/mat")
public class MembersMaterialsController {

    /**
     * 服务对象
     */
    @Resource
    private MembersMaterialsService membersMaterialsService;

    /**
     * 分页查询
     *
     * @param  params 请求参数集
     * @return 结果集封装对象 
     */
    @GetMapping("queryPager")
    public PageUtils queryPager(@RequestParam Map<String, Object> params) {
         Query query = new Query(params);
         List<MembersMaterials> list = membersMaterialsService.queryPager(query);
         return new PageUtils(list, query.getTotal());
    }

    /**
     * 修改字段项
     * @param membersMaterials
     * @return
     */
    @PostMapping("update")
    public R update(MembersMaterials membersMaterials){
        return R.update(this.membersMaterialsService.update(membersMaterials));
    }
}