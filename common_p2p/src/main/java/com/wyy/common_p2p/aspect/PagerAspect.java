package com.wyy.common_p2p.aspect;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wyy.common_p2p.rpc.sys.SysdictitemFeignApi;
import com.wyy.common_p2p.utils.Query;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description: 这是实现aop分页
 * @Author: cpc
 * @Date: 2019-10-15 15:12
 * @Version: V1.0
 */
@Component
@Aspect
public class PagerAspect {


    private SysdictitemFeignApi sysdictitemFeignApi;
    /**
     * 拦截Pager 结尾的方法 做分页
     * @param args
     * @return
     * @throws Throwable
     */
    @Around("execution( * com.mgdd.*.service.impl.*.*Pager(..))")
    public Object invoke(ProceedingJoinPoint args) throws Throwable {
        //获取产生列表
        Object[] params = args.getArgs();
        Query query = null;
        //找PageBean对象
        for (Object param : params) {
            if(param instanceof Query){
                query = (Query)param;
                break;
            }
        }
        //如果pageBean对象不为空就开启分页
        if(query != null) {
            PageHelper.startPage(query.getPage(), query.getRows());
        }
        //执行方法并且获取了结果集
        Object list = args.proceed(params);
        //将分页结果信息放入到PageBean对象中
        if(null != query){
            PageInfo pageInfo = new PageInfo((List) list);
            query.setTotal(pageInfo.getTotal());
        }
        return list;
    }
}