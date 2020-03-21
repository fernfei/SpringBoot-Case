/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: CustomFilterInvocationSecurityMetadataSource
 * Author:   Administrator
 * Date:     2020/1/14 8:44
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.security.config;

import com.fern.security.bean.Menu;
import com.fern.security.bean.Role;
import com.fern.security.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/1/14
 * @since 1.0.0
 */
@Component
public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    AntPathMatcher pathMatcher = new AntPathMatcher();
    @Autowired
    private MenuService menuService;
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        List<Menu> menus = menuService.getMenus();
        for (Menu menu : menus) {
            if (pathMatcher.match(menu.getPattern(), requestUrl)) {
                List<Role> roles = menu.getRoles();
                String[] roleStr = new String[roles.size()];
                for (int i = 0; i < roles.size(); i++) {
                    roleStr[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(roleStr);
            }
        }
        return SecurityConfig.createList("ROLE_def");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}