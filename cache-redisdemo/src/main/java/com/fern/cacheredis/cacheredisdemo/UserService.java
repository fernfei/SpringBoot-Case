/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: UserService
 * Author:   Administrator
 * Date:     2020/1/9 20:05
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.cacheredis.cacheredisdemo;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/1/9
 * @since 1.0.0
 */
@Service
@CacheConfig(cacheNames = "c1")
public class UserService {
    @Cacheable(key = "#id")
    public User getUserById(Integer id,String name) {
        System.out.println(">>>>>>>>>>>>>>>>Cacheable>>>>>>>>>>>>>>>");
        User user = new User();
        user.setId(id);
        user.setUserName(name);
        user.setAddress("American");
        return user;
    }

    @CacheEvict
    public void delete(Integer id) {
        System.out.println(">>>>>>>>>>>>>>CacheEvict>>>>>>>>>>>>>>>>>");
    }
    @CachePut(key = "#user.id")
    public User update(User user) {
        System.out.println(">>>>>>>>>>>>>>CachePut>>>>>>>>>>>>>>>>>>>");
        User user1 = user;
        return user1;
    }
}