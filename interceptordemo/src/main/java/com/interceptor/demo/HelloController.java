/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: HelloController
 * Author:   Administrator
 * Date:     2019/12/22 13:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.interceptor.demo;

import com.interceptor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/22
 * @since 1.0.0
 */
@RestController
public class HelloController {
    @Autowired
    private UserService userService;
    @Autowired
    private MyInterceptor myInterceptor;

    @GetMapping("/hello")
    public String hello() {

        myInterceptor.hufei();
        return "hello";
    }

    @GetMapping("/getUser")
    public String getUser(Integer id) {

        return userService.getUserName(id);
    }

    @GetMapping("/delUser")
    public String delUser(Integer id) {
        userService.delUserName(id);
        return "success";
    }
}