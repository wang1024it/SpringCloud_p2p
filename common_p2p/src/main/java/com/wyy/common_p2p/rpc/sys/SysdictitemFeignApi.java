package com.wyy.common_p2p.rpc.sys;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description:
 * @Author: cpc
 * @Date: 2019-12-11 14:26
 * @Version: V1.0
 */
@FeignClient(value = "SYS")//被调用方服务名
public interface SysdictitemFeignApi {

    @GetMapping("/queryDictTextByKey")
    String  queryDictTextByKey(@RequestParam("sn") String sn, @RequestParam("key") String key);
}
