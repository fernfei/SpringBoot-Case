/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: MyExceptionController
 * Author:   Administrator
 * Date:     2019/12/17 6:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.springbootdemo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/17
 * @since 1.0.0
 */
//全局异常扫描
@ControllerAdvice
public class MyExceptionController {
//放入要扫描的类，MaxUploadSizeExceededException是SpringBoot封装好的类，以后我们定义属于自己的异常类
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ModelAndView maxUploadException(MaxUploadSizeExceededException exception) throws  Exception{
        ModelAndView mv=new ModelAndView("error");
        mv.addObject("error","文件上传超出大小！！！");
        return mv;
    }
//    @ExceptionHandler(MaxUploadSizeExceededException.class)
//    public void maxUploadException(MaxUploadSizeExceededException ex, HttpServletResponse response) throws  Exception{
//        response.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
//        PrintWriter pw = response.getWriter();
//        pw.write("文件上传大小不得超出1KB");
//
//        pw.flush();
//        pw.close();
//    }
    //    @ExceptionHandler(MaxUploadSizeExceededException.class)
//    public String maxUploadException(MaxUploadSizeExceededException exception,Model model) throws  Exception{
//        ModelAndView mv=new ModelAndView();
//        mv.setViewName("error");
//        mv.addObject("error","文件上传超出大小！！！");
//        model.addAttribute("error","文件上传大小不得超出1KB");
//        return "error";
//    }
}