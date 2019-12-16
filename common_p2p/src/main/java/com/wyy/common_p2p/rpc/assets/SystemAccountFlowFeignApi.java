package com.wyy.common_p2p.rpc.assets;

import com.wyy.common_p2p.entity.assets.SystemAccountFlow;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: 系统账户流水对象
 * @Author: cpc
 * @Date: 2019-12-10 22:56
 * @Version: V1.0
 */
@FeignClient(value = "ASSETS")
public interface SystemAccountFlowFeignApi {

    /**
     * 新增数据
     *
     * @param systemAccountFlow 实例对象
     * @return 添加行数
     */
    @RequestMapping("/systemAccountFlow/insert")
    int insert(SystemAccountFlow systemAccountFlow);
}
