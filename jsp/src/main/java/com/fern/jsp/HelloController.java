/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: HelloController
 * Author:   Administrator
 * Date:     2020/1/21 16:29
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/1/21
 * @since 1.0.0
 */
@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(Model model) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "hufei");
        map.put("age", "21");
        model.addAttribute("map", map);
        System.out.println("======================");
        return "index";
    }
}