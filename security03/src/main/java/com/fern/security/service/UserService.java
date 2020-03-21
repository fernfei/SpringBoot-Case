/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: UserService
 * Author:   Administrator
 * Date:     2020/1/14 8:29
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.security.service;

import com.fern.security.bean.User;
import com.fern.security.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/1/14
 * @since 1.0.0
 */
@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.getUserById(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在！");
        }
        user.setRoles(userMapper.getRoles(user.getId()));
        return user;
    }
}