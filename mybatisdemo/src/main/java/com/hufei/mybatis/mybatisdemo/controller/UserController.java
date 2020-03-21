/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: UserController
 * Author:   Administrator
 * Date:     2019/12/27 20:37
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hufei.mybatis.mybatisdemo.controller;

import com.hufei.mybatis.mybatisdemo.mapper.UserMapper;
import com.hufei.mybatis.mybatisdemo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/27
 * @since 1.0.0
 */
@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/query")
    public void query() {
        List<User> allUser = userMapper.getAllUser();
        for (User user : allUser) {
            System.out.println(user);
        }
    }
}