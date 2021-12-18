package com.simple;

import com.simple.chat.server.WebSocketChatServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import javax.annotation.Resource;

@SpringBootApplication
@EnableCaching
@MapperScan(basePackages = "com.simple.**.dao")
public class AdmintoryApplication  implements CommandLineRunner {

    @Value("${netty.port}")
    private int port;

    @Resource
    private WebSocketChatServer server;


    public static void main(String[] args) {
        SpringApplication.run(AdmintoryApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        server.run(port);
    }
}
