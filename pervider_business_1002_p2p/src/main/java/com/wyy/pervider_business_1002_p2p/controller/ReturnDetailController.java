package com.wyy.pervider_business_1002_p2p.controller;

import com.wyy.common_p2p.entity.borrowing.ReturnDetail;
import com.wyy.common_p2p.utils.JwtSession;
import com.wyy.common_p2p.utils.PageUtils;
import com.wyy.common_p2p.utils.Query;
import com.wyy.common_p2p.utils.R;
import com.wyy.pervider_business_1002_p2p.service.ReturnDetailService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/returnDetail")
public class ReturnDetailController {

    @Resource
    private ReturnDetailService returnDetailService;


    /**
     * 分页查询
     *
     * @param params 请求参数集
     * @return 结果集封装对象
     */
    @GetMapping("queryPager")
    public PageUtils queryPager(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<ReturnDetail> list = returnDetailService.queryPager(query);
        return new PageUtils(list, query.getTotal());
    }

    @GetMapping()
    public PageUtils queryMembersPager(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        //这是put用户id到查询条件中
        query.put("toMembersId", JwtSession.getCurrentMembersId());
        List<ReturnDetail> list = returnDetailService.queryPager(query);
        return new PageUtils(list, query.getTotal());
    }
    /**
     * 新增数据
     *
     * @param returnDetail 实例对象
     * @return R 
     */
    @PostMapping("add")
    public R add(ReturnDetail returnDetail) {
        return R.update(returnDetailService.insert(returnDetail));
    }
    
    
    
    /**
     * 修改数据
     *
     * @param returnDetail 实例对象
     * @return R 
     */
    @PostMapping("update")
    public  R update(ReturnDetail returnDetail) {
        return R.update(returnDetailService.update(returnDetail));
    }
    
    /**
     * 删除数据
     *
     * @param id 主键
     * @return R 
     */
    @PostMapping("del")
    public  R del(Integer id) {
        return R.update(returnDetailService.deleteById(id));
    }
}