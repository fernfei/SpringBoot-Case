/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: HelloService
 * Author:   Administrator
 * Date:     2020/3/4 15:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/4
 * @since 1.0.0
 */
@Service
public class HelloService {
    @Scheduled(fixedDelay = 2000)
    public void fixedDelay(){
        System.out.println("fixedDelay>>"+new Date());
    }
    @Scheduled(fixedRate = 2000)
    public void fixedRate() {
       System.out.println("fixedRate>>" + new Date());
    }
    @Scheduled(cron = "0/5 * * * * ?")
    public void cron(){
        System.out.println("cron>>" + new Date());
    }
}