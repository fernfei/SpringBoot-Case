/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: ShiroConfig
 * Author:   Administrator
 * Date:     2020/1/16 8:09
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.shiro.config;

import com.fern.shiro.realm.MyRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/1/16
 * @since 1.0.0
 */
@Configuration
public class ShiroConfig {
    @Bean
    MyRealm myRealm() {
        return new MyRealm();
    }
    @Bean
    SecurityManager securityManager() {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(myRealm());
        return defaultWebSecurityManager;
    }

    @Bean
    ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean shiroBean = new ShiroFilterFactoryBean();
        shiroBean.setSecurityManager(securityManager());
        shiroBean.setLoginUrl("/login");
        shiroBean.setSuccessUrl("/welcome");
        Map<String, String> map = new LinkedHashMap<>();
        //登陆地址匿名访问
        map.put("/dologin", "anon");
        //剩下其他地址，认证后访问
        map.put("/**", "authc");
        //自定义拦截规则
        shiroBean.setFilterChainDefinitionMap(map);
        return shiroBean;
    }

    
}
