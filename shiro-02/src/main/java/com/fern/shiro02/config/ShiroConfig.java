/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: ShiroConfig
 * Author:   Administrator
 * Date:     2020/1/16 10:03
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.shiro02.config;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.TextConfigurationRealm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
    Realm realm() {
        TextConfigurationRealm realm = new TextConfigurationRealm();
        realm.setUserDefinitions("admin=123,admin \n user=123,user");
        realm.setRoleDefinitions("admin=read,write \n user=read");
        return realm;
    }

    @Bean
    ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition definition = new DefaultShiroFilterChainDefinition();
        definition.addPathDefinition("/dologin", "anon");
        definition.addPathDefinition("/**", "authc");
        return definition;
    }
}