/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: GlobalData
 * Author:   Administrator
 * Date:     2019/12/17 8:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.springbootdemo;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/17
 * @since 1.0.0
 */
@ControllerAdvice
public class GlobalData {
    @ModelAttribute(value = "data")
    public Map<String,Object> globalHandler(){
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("name", "张三");
        hashMap.put("address", "东京");
        return hashMap;
    }
}