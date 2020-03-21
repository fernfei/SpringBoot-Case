/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: MyFilter
 * Author:   Administrator
 * Date:     2020/1/14 3:18
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.security.config;

import com.fern.security.bean.Menu;
import com.fern.security.bean.Role;
import com.fern.security.mapper.MenuMapper;
import com.fern.security.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Arrays;
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
public class MyFilter implements FilterInvocationSecurityMetadataSource {
    AntPathMatcher pathMatcher = new AntPathMatcher();
    @Autowired
    private MenuService menuService;

    /**
     * 根据请求的url和数据库中存在的url匹配，从而分析出所需要的角色
     * @param object
     * @return  collection
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        List<Menu> allMenus = menuService.getAllMenus();
        for (Menu allMenu : allMenus) {
            if (pathMatcher.match(allMenu.getPattern(), requestUrl)) {
                List<Role> roles = allMenu.getRoles();
                String[] roleStr = new String[roles.size()];
                for (int i = 0; i < roles.size(); i++) {
                    roleStr[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(roleStr);
            }
        }
        //循环完都没有对应的url，那就返回一个默认的角色，意思是标记差不多
        return SecurityConfig.createList("ROLE_login");
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