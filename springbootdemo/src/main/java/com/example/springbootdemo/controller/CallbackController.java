/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: CallbackController
 * Author:   Administrator
 * Date:     2019/12/24 12:32
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/24
 * @since 1.0.0
 */
@Controller
public class CallbackController {
    @RequestMapping("/hello123")
    public String hello(Date birthday) {
        System.out.println(birthday);
        return "hello";
    }
}