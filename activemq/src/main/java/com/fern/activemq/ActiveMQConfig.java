/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: ActiveMQConfig
 * Author:   Administrator
 * Date:     2020/1/19 4:55
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.activemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/1/19
 * @since 1.0.0
 */
@Configuration
public class ActiveMQConfig {
    @Bean
    Queue queue() {
        //消息服务的名字|方便根据名字接受
        return new ActiveMQQueue("hello.fernfei");
    }
}
