/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: BookController
 * Author:   Administrator
 * Date:     2019/12/28 22:50
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.jpa.jpademo.controller;

import com.fern.jpa.jpademo.dao1.BookDao1;
import com.fern.jpa.jpademo.dao1.UserDao1;
import com.fern.jpa.jpademo.dao2.BookDao2;
import com.fern.jpa.jpademo.dao2.UserDao2;
import com.fern.jpa.jpademo.pojo.Book;
import com.fern.jpa.jpademo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/28
 * @since 1.0.0
 */
@RestController
public class BookController {
    @Autowired
    private BookDao1 bookDao1;
    @Autowired
    private BookDao2 bookDao2;
    @Autowired
    private UserDao1 userDao1;
    @Autowired
    private UserDao2 userDao2;
    @GetMapping("/add")
    public void add() {
        Book book = new Book();
        book.setName("NMSL");
        book.setAuthor("孙笑川");
        bookDao2.save(book);
    }

    @GetMapping("/add1")
    public void add1() {
        User user = new User();
        user.setUserName("FERN");
        userDao1.save(user);
        userDao2.save(user);
    }

    @GetMapping("/query1")
    public void query1() {
        List<Book> all = bookDao1.findAll();
        for (Book book : all) {
            System.out.println(book);
        }
    }

    @GetMapping("/query2")
    public void query2() {
        List<Book> all = bookDao2.findAll();
        for (Book book : all) {
            System.out.println(book);
        }
    }
}