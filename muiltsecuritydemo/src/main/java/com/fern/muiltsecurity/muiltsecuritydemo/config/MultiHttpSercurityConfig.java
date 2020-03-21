/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: MuiltHttpSercurityConfig
 * Author:   Administrator
 * Date:     2020/1/11 7:36
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.muiltsecurity.muiltsecuritydemo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
 * @create 2020/1/11
 * @since 1.0.0
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class MultiHttpSercurityConfig {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("root_test")
                .password("$2a$10$RMuFXGQ5AtH4wOvkUqyvuecpqUSeoxZYqilXzbz50dceRsga.WYiq").roles("ROOT")
                .and()
                .withUser("user_test")
                .password("$2a$10$RMuFXGQ5AtH4wOvkUqyvuecpqUSeoxZYqilXzbz50dceRsga.WYiq").roles("USER");

    }

    @Configuration
    @Order(1)
    public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/root/**")
                    .authorizeRequests().anyRequest().hasRole("ROOT");
//            http.authorizeRequests()
//                    .antMatchers("/root/**").hasRole("ROOT");
        }
    }
    @Configuration
    public class OtherSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .loginProcessingUrl("/user/dologin")
                    .usernameParameter("name")
                    .passwordParameter("pwd")
                    .successHandler(new AuthenticationSuccessHandler() {
                        @Override
                        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                            response.setContentType("application/json;charset=utf-8");
                            PrintWriter out = response.getWriter();
                            Map<String, Object> map = new HashMap<String, Object>();
                            map.put("status", 200);
                            map.put("msg", authentication.getPrincipal());
                            out.write(new ObjectMapper().writeValueAsString(map));
                            out.flush();
                            out.close();
                        }
                    })
                    .failureHandler(new AuthenticationFailureHandler() {
                        @Override
                        public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
                            response.setContentType("application/json;charset=utf-8");
                            PrintWriter out = response.getWriter();
                            Map<String, Object> map = new HashMap<String, Object>();
                            map.put("status", 401);
                            map.put("msg", "登陆异常，请重新登陆！");
                            out.write(new ObjectMapper().writeValueAsString(map));
                            out.flush();
                            out.close();
                        }
                    })
                    .permitAll()
                    .and()
                    .csrf().disable();
        }
    }
}