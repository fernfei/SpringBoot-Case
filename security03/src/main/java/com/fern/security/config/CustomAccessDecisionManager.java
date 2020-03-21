/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: CustomAccessDecisionManager
 * Author:   Administrator
 * Date:     2020/1/14 9:00
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.security.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

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
public class CustomAccessDecisionManager implements AccessDecisionManager {

    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        for (ConfigAttribute configAttribute : configAttributes) {
            if ("ROLE_def".equals(configAttribute.getAttribute())) {
                if (authentication instanceof AnonymousAuthenticationToken) {
                    System.out.println(">>>>>>>>>>>>>>>>>匿名用户>>>>>>>>>>>>>>>>>>");
                    throw new AccessDeniedException("权限不足，无法访问！");
                } else {
                    System.out.println(">>>>>>>>>>>>其他类型用户>>>>>>>>>>>>>>>>>>>>>");
                    return;
                }

            }
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>authority（账户所拥有的权限）:" + authority.getAuthority());
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>configAttribute（路径需要的角色）:" + configAttribute.getAttribute());
                if (authority.getAuthority().equals(configAttribute.getAttribute())) {
                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>进来>>>>>>>>>>>>>>>>>>>>>>");
                    return;
                }
            }
        }
        throw new AccessDeniedException("权限不足，无法访问！");
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