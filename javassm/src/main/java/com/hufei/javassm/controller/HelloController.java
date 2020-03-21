/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: HelloController
 * Author:   Administrator
 * Date:     2019/12/7 4:04
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hufei.javassm.controller;

import com.hufei.javassm.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/7
 * @since 1.0.0
 */
@RestController
public class HelloController {
    @Autowired
    HelloService helloService;
    @GetMapping(value = "/hello",produces = "text/html;charset=utf-8")

    public String hellow() {
        return helloService.sayhello();
    }
}