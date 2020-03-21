/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: JwtFilter
 * Author:   Administrator
 * Date:     2020/1/17 10:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.jwt.filter;

import io.jsonwebtoken.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import sun.plugin.liveconnect.SecurityContextHelper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/1/17
 * @since 1.0.0
 */
public class JwtFilter extends GenericFilter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        //获得http的头
        String jwtToken = req.getHeader("authorization");
        String token = new String(jwtToken.getBytes("ISO-8859-1"), "UTF-8");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>" + token);
        Claims claims = Jwts.parser().setSigningKey("fern@123")
                                                        //浏览器携带的token会带一个Bearer,所以要把它去除掉
                    .parseClaimsJws(token.replace("Bearer", "")).getBody();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>" +claims.toString());
        //获取当前用户名
        String username = claims.getSubject();
        List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList((String) claims.get("authorities"));
        UsernamePasswordAuthenticationToken tokenBean = new UsernamePasswordAuthenticationToken(username, null, authorities);//账号，密码，角色
        //校验
        SecurityContextHolder.getContext().setAuthentication(tokenBean);
        //过滤器继续往下走
        chain.doFilter(request, response);
    }


}