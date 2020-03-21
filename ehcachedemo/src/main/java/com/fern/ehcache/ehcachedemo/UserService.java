/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: UserService
 * Author:   Administrator
 * Date:     2020/1/10 1:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.ehcache.ehcachedemo;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/1/10
 * @since 1.0.0
 */
@Service
public class UserService {
    @Cacheable(cacheNames = "myehcache",key = "#id")
    public User getUserById(Integer id) {
        User user = new User();
        user.setId(id);
        user.setUserName("爷笑了");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        return user;
    }
}