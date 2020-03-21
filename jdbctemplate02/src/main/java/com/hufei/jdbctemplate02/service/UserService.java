/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: UserService
 * Author:   Administrator
 * Date:     2019/12/25 12:00
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hufei.jdbctemplate02.service;

import com.hufei.jdbctemplate02.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/25
 * @since 1.0.0
 */
@Service
public class UserService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public int delUser(Integer userId) {
        return jdbcTemplate.update("delete from user where userId=?", userId);
    }

    public int addUser(User user) {
        return jdbcTemplate.update("insert into user(userName,userPwd) values (?,?)",user.getUserName(), user.getUserPwd());

    }

    public int getUser(Integer userId) {
        return jdbcTemplate.update("select * from user where userId=?", userId);

    }

    public int updateUser(User user) {
        return jdbcTemplate.update("update user set userName=? where userId=?", user.getUserName(), user.getUserId());
    }

    public List<User> getAllUser() {
        List<User> update = jdbcTemplate.query("select  * from user ", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                int userId = rs.getInt("userId");
                String userName = rs.getString("userName");
                String userPwd = rs.getString("userPwd");
                return new User(userId, userName, userPwd);
            }
        });
        return update;
    }
    public List<User> getAllUser2(){
        return jdbcTemplate.query("select * from user", new BeanPropertyRowMapper<>(User.class));
    }
}