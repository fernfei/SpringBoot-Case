package com.fern.cacheredis.cacheredisdemo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.naming.Name;

@RunWith(SpringRunner.class)
@SpringBootTest
class CacheRedisdemoApplicationTests {
    @Autowired
    private UserService userService;
    @Test
    void contextLoads() {
        User userById1 = userService.getUserById(1,"Jerry");
        User userById2 = userService.getUserById(2,"Tom");
        System.out.println(userById1);
        System.out.println(userById2);
    }

    @Test
    void test01() {
        User str = userService.getUserById(2, "Tom");
        userService.delete(2);
        User str2 = userService.getUserById(2, "Tom");
        System.out.println(str);
        System.out.println(str2);
    }

    @Test
    void test02() {
        User user = new User();
        user.setId(2);
        user.setUserName("Rachel");
        user.setAddress("USA");
        User update = userService.update(user);
        User rachel = userService.getUserById(2, "Rachel");
        System.out.println(update);
        System.out.println(rachel);

    }

}
