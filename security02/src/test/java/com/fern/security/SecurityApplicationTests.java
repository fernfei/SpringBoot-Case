package com.fern.security;

import com.fern.security.mapper.MenuMapper;
import com.fern.security.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class SecurityApplicationTests {
    @Autowired
    MenuMapper menuMapper;
    @Autowired
    UserService userService;
    @Test
    void contextLoads() {
        System.out.println(menuMapper.getAllMenus());

    }



}
