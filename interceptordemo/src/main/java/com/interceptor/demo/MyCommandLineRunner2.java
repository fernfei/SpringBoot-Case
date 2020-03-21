/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: MyCommandLineRunner2
 * Author:   Administrator
 * Date:     2019/12/24 8:44
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
 * 〈〉系统启动任务2
 *
 * @author Administrator
 * @create 2019/12/24
 * @since 1.0.0
 */
@Component
@Order(1)
public class MyCommandLineRunner2 implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("MyCommandLineRunner2>>>>>>>>>>"+ Arrays.toString(args));
    }
}