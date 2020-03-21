/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: HelloController
 * Author:   Administrator
 * Date:     2020/1/14 5:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/1/14
 * @since 1.0.0
 */
@RestController
public class HelloController {
    @GetMapping("/dba/hello")
    public String dba() {
        return "hello dba!!!";
    }
    @GetMapping("/admin/hello")
    public String admin() {
        return "hello admin!!!";
    }
    @GetMapping("/user/hello")
    public String user() {
        return "hello user!!!";
    }
    @GetMapping("/hello")
    public String hello() {
        return "hello!!!";
    }
}