package com.fern.security.mapper;

import com.fern.security.bean.Role;
import com.fern.security.bean.User;

import java.util.List;

public interface UserMapper {
    User getUserByname(String username);

    List<Role> getRolesByid(Integer id);
}
