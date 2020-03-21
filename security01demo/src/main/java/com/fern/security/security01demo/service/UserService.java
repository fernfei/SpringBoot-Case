/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: UserService
 * Author:   Administrator
 * Date:     2020/1/13 20:55
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.security.security01demo.service;

import com.fern.security.security01demo.mapper.UserMapper;
import com.fern.security.security01demo.pojo.User;
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
 * @create 2020/1/13
 * @since 1.0.0
 */
@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.getUserByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在！");
        }
        user.setRoleList(userMapper.getRolesById(user.getId()));
        return user;
    }
}