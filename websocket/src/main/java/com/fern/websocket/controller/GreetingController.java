/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: GreetingController
 * Author:   Administrator
 * Date:     2020/1/17 16:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.websocket.controller;

import com.fern.websocket.bean.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/1/17
 * @since 1.0.0
 */
@RestController
public class GreetingController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    /*@MessageMapping("/hello")//这个url下的方法用来处理浏览器发送来的消息
    @SendTo("/topic/greetings")//再把信息转发到这个url
    public Message greeting(Message message) {
        return message;
    }*/
    @MessageMapping("/hello")//这个url下的方法用来处理浏览器发送来的消息
    public void greeting1(Message message) {
        simpMessagingTemplate.convertAndSend("/topic/greetings", message);
    }
}