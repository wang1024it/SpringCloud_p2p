package com.wyy.zuul_3001_p2p.config;

import com.wyy.zuul_3001_p2p.filter.MyCorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: zuul 配置类
 * @Author: cpc
 * @Date: 2019-12-11 11:49
 * @Version: V1.0
 */
@Configuration
public class ZuulConfig {

    /**
     * 这是配置 跨域组件
     * @return
     */
    @Bean
    public MyCorsFilter accessFilter(){
        return new MyCorsFilter();
    }
}
