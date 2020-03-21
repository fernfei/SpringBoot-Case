/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: JmsComponent
 * Author:   Administrator
 * Date:     2020/1/18 15:33
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/1/18
 * @since 1.0.0
 */
@Component
public class JmsComponent {
    @Autowired
    JmsMessagingTemplate jmsMessagingTemplate;//SpringBoot提供的操作activemq模板
    @Autowired
    Queue queue;

    public void send(Message msg) {
        //第一个参数是目标，第二个是信息
        jmsMessagingTemplate.convertAndSend(queue,msg);

    }
    //根据这个目标去监听
    @JmsListener(destination = "hello.fernfei")
    public void receive(Message msg) {
        System.out.println(msg);
    }
}