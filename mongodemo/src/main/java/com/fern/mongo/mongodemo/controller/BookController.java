/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: BookController
 * Author:   Administrator
 * Date:     2020/1/6 4:03
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.mongo.mongodemo.controller;

import com.fern.mongo.mongodemo.dao.BookDao;
import com.fern.mongo.mongodemo.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/1/6
 * @since 1.0.0
 */
@RestController
public class BookController {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/insert")
    public String insert() {
        Book book = new Book();
        book.setId(2);
        book.setName("水浒传");
        bookDao.insert(book);
        return "success";
    }

    @GetMapping("/query")
    public String query() {
        List<Book> book = bookDao.findBookByNameContaining("水");
        for (Book book1 : book) {
            System.out.println(book);
        }
        return "success";
    }

    @GetMapping("queryAll")
    public String queryAll() {
        List<Book> all = bookDao.findAll();
        for (Book book : all) {
            System.out.println(book);
        }
        return "success";
    }

    @GetMapping("/insertmongo")
    public String insert01() {
        Book book = new Book();
        book.setId(3);
        book.setName("三国演义");
        mongoTemplate.insert(book);
        return "success";
    }

    @GetMapping("querymongo")
    public String query02() {
        List<Book> all = mongoTemplate.findAll(Book.class);
        for (Book book : all) {
            System.out.println(book);

        }
        return "success";
    }
}