package com.hufei.jdbctemplate02.jdbctemplate02;

import com.hufei.jdbctemplate02.pojo.User;
import com.hufei.jdbctemplate02.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class Jdbctemplate02ApplicationTests {
    @Autowired
    private UserService userService;
    @Test
    void contextLoads() {
        User user = new User();
        user.setUserName("hufei");
        user.setUserPwd("love");
        userService.addUser(user);
    }

}
