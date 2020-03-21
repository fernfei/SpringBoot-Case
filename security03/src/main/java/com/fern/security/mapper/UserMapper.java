package com.fern.security.mapper;

import com.fern.security.bean.Role;
import com.fern.security.bean.User;

import java.util.List;

public interface UserMapper {
    User getUserById(String username);

    List<Role> getRoles(Integer id);
}
