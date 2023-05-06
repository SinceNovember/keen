package com.simple.keen;

import com.simple.keen.server.WebSocketServer;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author SinceNovember
 * @date 2022/11/19
 */
@SpringBootApplication
@EnableScheduling
public class KeenApplication implements ApplicationRunner {

    @Value("${server.message-port:9999}")
    private int port;

    @Resource
    private WebSocketServer server;

    public static void main(String[] args) {
        new SpringApplicationBuilder(KeenApplication.class)
            .build()
            .run(args);
    }

    @Override
    public void run(ApplicationArguments args) {
        server.run(port);
    }

}
