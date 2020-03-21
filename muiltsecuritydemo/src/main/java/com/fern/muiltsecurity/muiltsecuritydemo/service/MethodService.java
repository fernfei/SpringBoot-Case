/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: MethodService
 * Author:   Administrator
 * Date:     2020/1/13 5:56
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.muiltsecurity.muiltsecuritydemo.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
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
public class MethodService {
    @PreAuthorize("hasRole('ROOT')")
    public String root() {
        return "hello,method,root";
    }

    @Secured("ROLE_USER")
    public String user() {
        return "hello,method,user";
    }

    @PreAuthorize("hasAnyRole('ROOT','USER')")
    public String hello() {
        return "hello,method,hello";
    }
}