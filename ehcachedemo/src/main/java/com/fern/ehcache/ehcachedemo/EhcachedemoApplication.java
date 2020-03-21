package com.fern.ehcache.ehcachedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EhcachedemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EhcachedemoApplication.class, args);
    }

}
