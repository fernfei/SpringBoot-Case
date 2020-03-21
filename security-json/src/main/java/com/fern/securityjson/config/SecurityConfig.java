/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: SecurityConfig
 * Author:   Administrator
 * Date:     2020/1/16 12:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.securityjson.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fern.securityjson.filter.MyAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
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
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                //将自定义的过滤加进来，第二参数表示加到UsernamePasswordAuthenticationFilter所在的位置
                .addFilterAt(myAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                .loginProcessingUrl("/dologin")
                .permitAll()
                .and()
                .csrf().disable();
    }

    @Bean
    MyAuthenticationFilter myAuthenticationFilter() throws Exception {
        MyAuthenticationFilter filter = new MyAuthenticationFilter();
        filter.setAuthenticationManager(super.authenticationManagerBean());
        filter.setFilterProcessesUrl("/jsonLogin");
        filter.setAuthenticationSuccessHandler(new AuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                response.setContentType("application/json;charset=utf-8");
                PrintWriter out = response.getWriter();
                Map<String, Object> map = new HashMap<>();
                map.put("status", 200);
                map.put("msg", authentication.getPrincipal());
                out.write(new ObjectMapper().writeValueAsString(map));
                out.flush();
                out.close();
            }
        });
        return filter;
    }
}