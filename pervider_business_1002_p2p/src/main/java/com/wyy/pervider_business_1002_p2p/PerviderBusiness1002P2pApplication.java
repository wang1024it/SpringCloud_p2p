package com.wyy.pervider_business_1002_p2p;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;


//自动扫描Mapper目录,如果要扫描多个： @MapperScan({”com.xxx.dao”,”com.xxx.entity”})
@MapperScan("com.wyy.pervider_business_1002_p2p.dao")
//启用事物管理器
@EnableTransactionManagement
//这是 feign 调用的扫描
@EnableFeignClients(basePackages = {"com.wyy.*.*"})
@EnableEurekaClient
@SpringBootApplication(scanBasePackages="com.wyy")
public class PerviderBusiness1002P2pApplication {

    public static void main(String[] args) {
        SpringApplication.run(PerviderBusiness1002P2pApplication.class, args);
    }


}
