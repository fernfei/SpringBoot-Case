/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: UserDao
 * Author:   Administrator
 * Date:     2020/1/9 1:05
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.jparest.jparestdemo.dao;

import com.fern.jparest.jparestdemo.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/1/9
 * @since 1.0.0
 */
@CrossOrigin
@RepositoryRestResource(path = "query",collectionResourceRel = "collectionuser",itemResourceRel = "itemuser")
public interface UserDao extends JpaRepository<User, Integer> {
    @RestResource(path = "byname",rel = "findbyname")
    List<User> findUserByUserNameContaining(@Param("name") String name);
}