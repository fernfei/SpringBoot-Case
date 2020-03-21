/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: UserService
 * Author:   Administrator
 * Date:     2019/12/26 20:11
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jdbctemplate.demo.service;

import com.jdbctemplate.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/26
 * @since 1.0.0
 */
@Service
public class UserService {
    @Autowired
    @Qualifier("jdbcTemplateOne")
    private JdbcTemplate jdbcTemplateOne;
    @Autowired
    @Qualifier("jdbcTemplateTwo")
    private JdbcTemplate jdbcTemplateTwo;
    public List<User> getAllUser() {
        return jdbcTemplateOne.query("select * from user", new BeanPropertyRowMapper<>(User.class));
    }

    public List<User> getAllUser2() {
        return jdbcTemplateTwo.query("select * from user",new BeanPropertyRowMapper<>(User.class));
    }
}