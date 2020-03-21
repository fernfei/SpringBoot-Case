/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: FileUploadController
 * Author:   Administrator
 * Date:     2019/12/16 1:44
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/16
 * @since 1.0.0
 */
@RestController
public class FileUploadController {
    SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd");
    @PostMapping("/upload")
    public String upload(MultipartFile file, HttpServletRequest request){
            //创建一个图片目录
            String filePath=request.getSession().getServletContext().getRealPath("/img")+sdf.format(new Date());
            File folder =new File(filePath);
            if(!folder.exists()){
                folder.mkdirs();
            }
            String oldName=file.getOriginalFilename();
            String newName=UUID.randomUUID().toString()+oldName.substring(oldName.indexOf("."));
            try {
                file.transferTo(new File(folder,newName));
                String url=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/img"+sdf.format(new Date());
                return url;
            } catch (Exception e) {
                e.printStackTrace();
            }
        return "error";
    }

}