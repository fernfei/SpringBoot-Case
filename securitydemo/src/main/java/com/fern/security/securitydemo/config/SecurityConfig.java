/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: SecurityConfig
 * Author:   Administrator
 * Date:     2020/1/10 23:04
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.security.securitydemo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

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
 * @create 2020/1/10
 * @since 1.0.0
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("root").password("123").roles("admin")
                .and()
                .withUser("admin").password("123").roles("user");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("admin")
                .antMatchers("/db/**").hasAnyRole("admin","user")
                .antMatchers("/user/**").access("hasAnyRole('admin','user')")
                //剩下的其他路径请求验证之后就可以访问
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/dologin")
                .loginPage("/login")
                .usernameParameter("uname")
                .passwordParameter("pwd")
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");
                        PrintWriter pw = response.getWriter();
                        Map<String, Object> map = new HashMap<String, Object>();
                        map.put("status", 200);
                        map.put("msg", authentication.getPrincipal());
                        pw.write(new ObjectMapper().writeValueAsString(map));
                        pw.flush();
                        pw.close();
                    }
                })
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");
                        PrintWriter pw = response.getWriter();
                        Map<String, Object> map = new HashMap<String, Object>();
                        map.put("status", 401);
                        if (exception instanceof LockedException) {
                            map.put("msg", "账户被锁定，登陆失败！");
                        } else if (exception instanceof BadCredentialsException) {
                            map.put("msg", "账户或者密码错误，登陆失败！");
                        } else if (exception instanceof DisabledException) {
                            map.put("msg", "账户被禁用，登陆失败！");
                        } else if (exception instanceof AccountExpiredException) {
                            map.put("msg", "账户已过期，登陆失败！");
                        } else if (exception instanceof CredentialsExpiredException) {
                            map.put("msg", "密码已过期，登陆失败！");
                        } else {
                            map.put("msg", "登陆失败！");
                        }
                        pw.write(new ObjectMapper().writeValueAsString(map));
                        pw.flush();
                        pw.close();
                    }
                })
                .permitAll()
                .and()
                .csrf().disable();
    }
}