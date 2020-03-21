/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: GlobalController
 * Author:   Administrator
 * Date:     2019/12/17 8:46
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.springbootdemo.controller;

import com.example.springbootdemo.Author;
import com.example.springbootdemo.Book;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/17
 * @since 1.0.0
 */
@RestController
public class GlobalController {
    @GetMapping("/hello")
    public String hello(Model model){
        Map<String, Object> map = model.asMap();
        Set<String> keyset = map.keySet();
        for (String s : keyset) {
            System.out.println("key："+s+"value:"+map.get(s));
        }
        return "hello";
    }

    @PostMapping("/hello")
    public void bookandAuthor(@ModelAttribute("book") Book book,@ModelAttribute("author") Author author) {
        System.out.println(book);
        System.out.println(author);
    }
}