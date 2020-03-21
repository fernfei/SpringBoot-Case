/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: HelloController
 * Author:   Administrator
 * Date:     2020/1/11 7:33
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.muiltsecurity.muiltsecuritydemo.controller;

import com.fern.muiltsecurity.muiltsecuritydemo.service.MethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/1/11
 * @since 1.0.0
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello!";
    }

    @GetMapping("/root/hello")
    public String admin() {
        return "hello,admin!";
    }

    @GetMapping("/user/hello")
    public String user() {
        return "hello,user!";
    }

    @Autowired
    private MethodService methodService;

    @GetMapping("/hello1")
    public String hello1() {
        return methodService.root();
    }
    @GetMapping("/hello2")
    public String hello2() {
        return methodService.user();
    }
    @GetMapping("/hello3")
    public String hello3() {
        return methodService.hello();
    }
}