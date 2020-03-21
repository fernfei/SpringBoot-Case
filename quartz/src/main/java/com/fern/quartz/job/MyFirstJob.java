/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: MyFirstJob
 * Author:   Administrator
 * Date:     2020/3/4 17:32
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.quartz.job;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/4
 * @since 1.0.0
 */
@Component
public class MyFirstJob {
    public void firstJob(){
        System.out.println("my first job say hello:" + new Date());
    }
}