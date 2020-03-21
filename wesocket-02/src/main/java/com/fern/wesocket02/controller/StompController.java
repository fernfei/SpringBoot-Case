/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: StompController
 * Author:   Administrator
 * Date:     2020/1/18 9:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.wesocket02.controller;

import com.fern.wesocket02.bean.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/1/18
 * @since 1.0.0
 */
@RestController
public class StompController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/hello")
    public void chat(Principal principal, Chat chat) {
        chat.setFrom(principal.getName());
        simpMessagingTemplate.convertAndSendToUser(chat.getTo(), "/queue/greetings", chat);
    }

    @GetMapping("/hello1")
    public String hello(Principal principal, Authentication auth) {
        System.out.println(">>>>>>>>>>>>>>>>>>"+auth.getPrincipal());
        return principal.getName();
    }
}