package com.wyy.config_server_p2p;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 这是配置中心启动类
 */
@EnableConfigServer
@SpringBootApplication
public class ConfigServerP2pApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerP2pApplication.class, args);
    }

}
