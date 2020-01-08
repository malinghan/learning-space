package com.mlh.zipkin.server.demo.zipkinserverdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class ZipkinServerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinServerDemoApplication.class, args);
    }

}
