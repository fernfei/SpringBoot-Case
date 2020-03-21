/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: DateConverter
 * Author:   Administrator
 * Date:     2019/12/24 14:32
 * Description: 日期转换类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.springbootdemo.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈日期转换类〉
 *
 * @author Administrator
 * @create 2019/12/24
 * @since 1.0.0
 */
@Component
public class DateConverter implements Converter<String, Date> {
    SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public Date convert(String source) {
        try {
            return format.parse(source);
            
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}