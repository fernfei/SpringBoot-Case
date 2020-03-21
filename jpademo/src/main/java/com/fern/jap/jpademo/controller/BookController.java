/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: BookController
 * Author:   Administrator
 * Date:     2019/12/28 17:29
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.jap.jpademo.controller;

import com.fern.jap.jpademo.dao.BookDao;
import com.fern.jap.jpademo.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

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
    private BookDao bookDao;

    @GetMapping("/add")
    public String add() {
        Book book = new Book();
        book.setBookName("西游记");
        book.setBookAuthor("六小龄童");
        bookDao.save(book);
        return "success";
    }

    @GetMapping("/update")
    public String update() {
        Book book = new Book();
        book.setBookId(3);
        book.setBookName("西游记");
        book.setBookAuthor("吴承恩");
        bookDao.saveAndFlush(book);
        return "success";
    }

    @GetMapping("/del")
    public String delete() {
        Book book = new Book();
        book.setBookId(1);
        bookDao.delete(book);
        return "success";
    }

    @GetMapping("/query")
    public String queryAll() {
        Optional<Book> byId = bookDao.findById(3);
        System.out.println(byId.get().getBookName());
        List<Book> all = bookDao.findAll();
        for (Book book : all) {
            System.out.println(book);
        }
        return "success";
    }

    @GetMapping("/page")
    public String page() {
        Pageable pageable = PageRequest.of(0, 2);
        Page<Book> page = bookDao.findAll(pageable);
        System.out.println("总记录数：" + page.getTotalElements());
        System.out.println("总页数：" + page.getTotalPages());
        System.out.println("每页记录数：" + page.getSize());
        System.out.println("当前页记录数：" + page.getNumberOfElements());
        System.out.println("结果集：" + page.getContent());
        System.out.println("当前页（从0开始）：" + page.getNumber());
        System.out.println("是否为首页:" + page.isFirst());
        System.out.println("是否为尾页：" + page.isLast());
        return "success";
    }

    @GetMapping("/test")
    public String find1() {
        Book name = bookDao.findBookByBookIdAndAndBookName(3, "西游记");
        System.out.println(name);
        return "success";
    }

    @GetMapping("/test1")
    public String find2() {
        Book maxIdBook = bookDao.findMaxIdBook();
        System.out.println(maxIdBook);
        return "success";
    }

    @GetMapping("/test2")
    public String find3() {
        List<Book> book = bookDao.findAll(Sort.by(Sort.Direction.DESC, "bookId"));
        for (Book book1 : book) {
            System.out.println(book1);
        }
        return "success";
    }

    @GetMapping("/add1")
    public String add1() {
        Integer result = bookDao.addBookOne("朝花夕拾", "鲁迅");
        System.out.println(result + ">>>>>>>>>>>>>>>>>>>>>>>>");
        Integer result2 = bookDao.addBookTwo("呐喊", "鲁迅");
        System.out.println(result2 + ">>>>>>>>>>>>>>>>>>>>>>>>>");
        return "success";
    }

}