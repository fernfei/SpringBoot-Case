/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: MyErrorViewResolver
 * Author:   Administrator
 * Date:     2019/12/22 8:48
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.exception.config;

import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.DefaultErrorViewResolver;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/22
 * @since 1.0.0
 */
@Component
public class MyErrorViewResolver extends DefaultErrorViewResolver {

    /**
     * Create a new {@link DefaultErrorViewResolver} instance.
     *
     * @param applicationContext the source application context
     * @param resourceProperties resource properties
     */
    public MyErrorViewResolver(ApplicationContext applicationContext, ResourceProperties resourceProperties) {
        super(applicationContext, resourceProperties);
    }

    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("500");
        modelAndView.addAllObjects(model);

        return modelAndView;
    }

}