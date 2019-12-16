package com.wyy.common_p2p.utils;

import java.util.HashMap;
import java.util.Map;


/**
 * @Description: 这是返回结果集封装对象 （应为继承了HashMap所以非常扩展成自己想要用到的样子）
 * @Author: cpc
 * @Date: 2019-10-15 22:07
 * @Version: V1.0
 * r == Map
 *
 *
 * new R()
 * {
 *     code:500,
 *     msg: 操作失败
 * }
 *
 * query  ===> 封装查询参数   (分页 查询参数  )
 *
 * PageUtile ====》 封装返回结果 （totlo data）
 *
 */
public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public R() {
        put("code", 0);
        put("msg", "操作成功");
    }


    public static R error() {
        return error(500, "操作失败");
    }

    public static R error(String msg) {
        return error(500, msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R ok() {
        return new R();
    }


    /**
     * 这是更具状态来觉得返回信息，如果 大于 1 成功 如果小于 1 失败
     * @param n
     * @return
     */
    public static R update(int n) {
        return n > 0? R.ok("操作成功") : R.error("操作失败");
    }


    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}

