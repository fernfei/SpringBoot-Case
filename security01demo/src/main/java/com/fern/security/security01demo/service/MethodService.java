/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: MethodService
 * Author:   Administrator
 * Date:     2020/1/14 0:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.security.security01demo.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
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
public class MethodService {
    @PreAuthorize("hasRole('ROLE_dba')")
    public String dba() {
        return "hello method dba!!!";
    }
    @PreAuthorize("hasAnyRole('ROlE_dba','ROLE_admin')")
    public String admin() {
        return "hello method admin!!!";
    }
    @Secured("ROLE_user")
    public String user() {
        return "hello method user!!!";
    }
}