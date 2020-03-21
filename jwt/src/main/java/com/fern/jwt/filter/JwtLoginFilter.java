/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: JwtLoginFilter
 * Author:   Administrator
 * Date:     2020/1/17 8:57
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.jwt.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fern.jwt.pojo.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/1/17
 * @since 1.0.0
 */
public class JwtLoginFilter extends AbstractAuthenticationProcessingFilter {

    public JwtLoginFilter(String defaultFilterProcessesUrl, AuthenticationManager authenticationManager) {
        //登陆处理的url
         super(new AntPathRequestMatcher(defaultFilterProcessesUrl));
         //AuthenticationManager校验的核心类|存放着用户信息
         super.setAuthenticationManager(authenticationManager);
     }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        //json登陆
        User user = new ObjectMapper().readValue(request.getInputStream(), User.class);
        //authenticate()是自动校验账号密码是否正确的方法
        return super.getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        //Authentication存放着登陆成功后的用户信息
        Collection<? extends GrantedAuthority> authorities = authResult.getAuthorities();
        StringBuffer sb = new StringBuffer();
        for (GrantedAuthority authority : authorities) {
            sb.append(authority.getAuthority()).append(",");
            String jwt = Jwts.builder()
                    //配置用户的角色
                    .claim("authorities", sb)
                    //设置主题|这里主题是用户名
                    .setSubject(authResult.getName())
                    //设置过期时间
                    .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
                    //选择你自己的加密算法，key
                    .signWith(SignatureAlgorithm.HS512, "fern@123")
                    .compact();
            Map<String, String> map = new HashMap<>();
            map.put("token", jwt);
            map.put("msg", "success");
            response.setContentType("application/json;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.write(new ObjectMapper().writeValueAsString(map));
            out.flush();
            out.close();

        }
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        Map<String, String> map = new HashMap<>();
        map.put("status", "500");
        map.put("msg", failed.getMessage());
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write(new ObjectMapper().writeValueAsString(map));
        out.flush();
        out.close();
    }
}