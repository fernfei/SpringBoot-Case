package com.fern.cacheredis.cacheredisdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CacheRedisdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CacheRedisdemoApplication.class, args);
    }

}
