/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: BookDao
 * Author:   Administrator
 * Date:     2020/1/9 16:36
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.mongorest.mongorestdemo.dao;

import com.fern.mongorest.mongorestdemo.pojo.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/1/9
 * @since 1.0.0
 */
public interface BookDao extends MongoRepository<Book, Integer> {


}