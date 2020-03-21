package com.fern.security.security01demo;

import com.fern.security.security01demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Security01demoApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {

    }

}
