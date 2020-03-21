/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: BookDao
 * Author:   Administrator
 * Date:     2019/12/28 17:18
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.jap.jpademo.dao;

import com.fern.jap.jpademo.pojo.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/28
 * @since 1.0.0
 */
public interface BookDao extends JpaRepository<Book,Integer> {
    Book findBookByBookIdAndAndBookName(Integer bookId, String bookName);

    @Query(value = "select * from t_book where id=(select max(id) from t_book)", nativeQuery = true)
    Book findMaxIdBook();

    @Query(value = "insert  into t_name(name,author) values(?,?)",nativeQuery = true)
    @Modifying
    @Transactional
    Integer addBookOne(String bookName,String bookAuthor);

    @Query(value = "insert  into t_book(name,author) values(:name,:author)",nativeQuery = true)
    @Modifying
    @Transactional
    Integer addBookTwo(@Param("name")String bookName,@Param("author")String author);
}