/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: UserController
 * Author:   Administrator
 * Date:     2019/12/26 9:54
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hufei.jdbctemplate02.controller;

import com.hufei.jdbctemplate02.pojo.User;
import com.hufei.jdbctemplate02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/26
 * @since 1.0.0
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/add")
    public void hello() {
        User user = new User();
        user.setUserName("nmsl");
        user.setUserPwd("hello");
        int result = userService.addUser(user);

    }
    @GetMapping("/del")
    public void del() {

        int result = userService.delUser(1);

    }
    @GetMapping("/update")
    public void update() {
        User user = new User();
        user.setUserId(1);
        user.setUserName("珍珍");
        int result = userService.updateUser(user);

    }
    @GetMapping("/query")
    public void query() {

        List<User> result = userService.getAllUser();
        for (User user : result) {
            System.out.println(user);
        }

    }
}