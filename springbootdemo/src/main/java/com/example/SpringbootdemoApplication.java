package com.example;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringbootdemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringbootdemoApplication.class, args);
        SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringbootdemoApplication.class);
        SpringApplication build = builder.build(args);
        build.setBannerMode(Banner.Mode.OFF);
        build.run(args);
    }

}
