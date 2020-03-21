package com.fern.security.security01demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.fern.security.security01demo.mapper")
public class Security01demoApplication {

    public static void main(String[] args) {
        SpringApplication.run(Security01demoApplication.class, args);
    }

}
