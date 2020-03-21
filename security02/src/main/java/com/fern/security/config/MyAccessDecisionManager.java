/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: MyAccessDecisionManager
 * Author:   Administrator
 * Date:     2020/1/14 4:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.security.config;

import com.fern.security.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/1/14
 * @since 1.0.0
 */
@Component
public class MyAccessDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        for (ConfigAttribute configAttribute : configAttributes) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>角色："+configAttribute.getAttribute());
            if ("ROLE_login".equals(configAttribute.getAttribute())) {
                if (authentication instanceof AnonymousAuthenticationToken) {
                    throw new AccessDeniedException("非法请求!");
                }else{
                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>其他类型请求>>>>>>>>>>>>>>>>>>>>>>>>>");
                    return;
                }
            }
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                //比较登陆的用户角色是否匹配
                if (authority.getAuthority().equals(configAttribute.getAttribute())) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("非法请求！");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}