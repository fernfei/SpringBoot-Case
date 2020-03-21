/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: webInit
 * Author:   Administrator
 * Date:     2019/12/5 23:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hufei.javassm.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/5
 * @since 1.0.0
 */
public class WebInit implements WebApplicationInitializer {

    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.setServletContext(servletContext);
        ctx.register(SpringMVCConfig.class);
        ServletRegistration.Dynamic springmvc = servletContext.addServlet("springmvc", new DispatcherServlet(ctx));
        springmvc.addMapping("/");
        springmvc.setLoadOnStartup(1);

    }
}