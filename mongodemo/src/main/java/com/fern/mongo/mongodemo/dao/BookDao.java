/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: BookDao
 * Author:   Administrator
 * Date:     2020/1/6 4:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.mongo.mongodemo.dao;

import com.fern.mongo.mongodemo.pojo.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/1/6
 * @since 1.0.0
 */
public interface BookDao extends MongoRepository<Book, Integer> {
    List<Book> findBookByNameContaining(String name);

}