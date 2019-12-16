package com.wyy.eureka_server_p2p;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerP2pApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerP2pApplication.class, args);
    }

}
