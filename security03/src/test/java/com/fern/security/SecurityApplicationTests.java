package com.fern.security;

import com.fern.security.mapper.MenuMapper;
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
    @Test
    void contextLoads() {
        System.out.println(menuMapper.getMenus());

    }

}
