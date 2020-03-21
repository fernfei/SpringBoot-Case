/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: MyCommandLineRunner1
 * Author:   Administrator
 * Date:     2019/12/24 8:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.interceptor.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉系统启动任务1
 *
 * @author Administrator
 * @create 2019/12/24
 * @since 1.0.0
 */
@Component
@Order(2)
public class MyCommandLineRunner1 implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("MyCommandLineRunner1>>>>>>>>>>>"+ Arrays.toString(args));
    }
}