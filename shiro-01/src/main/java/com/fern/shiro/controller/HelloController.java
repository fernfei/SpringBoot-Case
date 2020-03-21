/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: HelloController
 * Author:   Administrator
 * Date:     2020/1/16 8:50
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.shiro.controller;

import com.fern.shiro.realm.MyRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/1/16
 * @since 1.0.0
 */
@RestController
public class HelloController {
    @GetMapping("/login")
    public String login() {
        return "please login!!!";
    }

    @PostMapping("/dologin")
    public String dologin(String username, String password) {
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(username,password));
            return "success!!!";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return e.getMessage();
        }

    }

    @GetMapping("/welcome")
    public String hello() {
        return "hello!!!";
    }
}