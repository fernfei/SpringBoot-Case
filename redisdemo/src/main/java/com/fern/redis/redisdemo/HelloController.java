/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: HelloController
 * Author:   Administrator
 * Date:     2019/12/31 22:05
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.redis.redisdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/31
 * @since 1.0.0
 */
@RestController
public class HelloController {
    @Autowired
    StringRedisTemplate redisTemplat;

    @GetMapping("/set")
    public void set() {
        ValueOperations<String, String> stringStringValueOperations = redisTemplat.opsForValue();
        stringStringValueOperations.set("FERN", "HELLO");
    }

    @GetMapping("/get")
    public void get() {
        ValueOperations<String, String> stringStringValueOperations = redisTemplat.opsForValue();
        System.out.println(stringStringValueOperations.get("FERN"));

    }
}