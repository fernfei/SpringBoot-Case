/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: HelloController
 * Author:   Administrator
 * Date:     2019/12/22 11:43
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cors.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
//@CrossOrigin(origins = "http://localhost:8080")
public class HelloController {
    @GetMapping("/gethello")
    public String hello() {
        return "NMSL";
    }
    @PutMapping("puthello")
    public String puthello(){
        return "孙笑川";
    }
}