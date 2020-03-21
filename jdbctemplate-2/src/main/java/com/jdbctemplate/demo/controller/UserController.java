/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: UserController
 * Author:   Administrator
 * Date:     2019/12/26 20:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jdbctemplate.demo.controller;

import com.jdbctemplate.demo.pojo.User;
import com.jdbctemplate.demo.service.UserService;
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
    @GetMapping("/query1")
    public void query() {
        List<User> allUser = userService.getAllUser();
        for (User user : allUser) {
            System.out.println(user);
        }
    }
    @GetMapping("/query2")
    public void query2() {
        List<User> allUser = userService.getAllUser2();
        for (User user : allUser) {
            System.out.println(user);
        }
    }
}