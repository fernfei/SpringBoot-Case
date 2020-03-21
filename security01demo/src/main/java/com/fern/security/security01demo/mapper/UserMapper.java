/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: UserDao
 * Author:   Administrator
 * Date:     2020/1/13 20:50
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.security.security01demo.mapper;

import com.fern.security.security01demo.pojo.Role;
import com.fern.security.security01demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/1/13
 * @since 1.0.0
 */
public interface UserMapper {
    User getUserByName(String name);

    List<Role> getRolesById(Integer id);
}