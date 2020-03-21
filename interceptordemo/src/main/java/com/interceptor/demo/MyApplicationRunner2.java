/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: MyApplicationRunner2
 * Author:   Administrator
 * Date:     2019/12/24 9:13
 * Description: 系统启动任务
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.interceptor.demo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * 〈一句话功能简述〉<br> 
 * 〈系统启动任务〉
 *
 * @author Administrator
 * @create 2019/12/24
 * @since 1.0.0
 */
@Component
@Order(3)
public class MyApplicationRunner2 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //        args.getSourceArgs(); 则表示获取命令行中的所有参数。
        String[] sourceArgs = args.getSourceArgs();
        System.out.println("sourceArgs2>>>>>>>>>>"+ Arrays.toString(sourceArgs));
//      args.getNonOptionArgs();可以用来获取命令行中的无key参数（和CommandLineRunner一样）。
        List<String> nonOptionArgs = args.getNonOptionArgs();
        System.out.println("nonOptionArgs2>>>>>>>>>>>"+nonOptionArgs);
//        args.getOptionNames();可以用来获取所有key/value形式的参数的key。
        Set<String> optionNames = args.getOptionNames();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        for (String optionName : optionNames) {
//        args.getOptionValues(key));可以根据key获取key/value 形式的参数的value。
            System.out.println(optionName+">>>>>>>>>>"+args.getOptionValues(optionName));
        }
        System.out.println("\n");
        System.out.println(">>>>>>>>>>>>>>>>>applicationrunner2结束>>>>>>>>>>>>>>>>>>>>>>>");

    }
}