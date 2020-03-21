/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: HelloController
 * Author:   Administrator
 * Date:     2019/12/22 6:47
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.exception.controller;

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
    @GetMapping("/helloerror")
    public String hello(){
        int i = 1 / 0;
        return "hello,world!!!";
    }
}