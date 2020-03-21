/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: GlobalHandler
 * Author:   Administrator
 * Date:     2019/12/17 9:12
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.springbootdemo;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/17
 * @since 1.0.0
 */
@ControllerAdvice
public class GlobalHandler {
    @InitBinder("book")
    public void book(WebDataBinder binder){
        binder.setFieldDefaultPrefix("book.");
    }
    @InitBinder("author")
    public void author(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("author.");
    }
}