/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: UserServiceImpl
 * Author:   Administrator
 * Date:     2019/12/24 16:10
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.interceptor.service;

import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/24
 * @since 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public String getUserName(Integer id) {
       System.out.println("getUserName");
        return "success";
    }

    @Override
    public void delUserName(Integer id) {
        System.out.println("delUserName");
    }
}