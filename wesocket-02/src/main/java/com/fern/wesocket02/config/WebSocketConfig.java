/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: WebSocketConfig
 * Author:   Administrator
 * Date:     2020/1/18 9:08
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.wesocket02.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/1/18
 * @since 1.0.0
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //消息代理的前缀|如果前端发的消息前缀是queue，这个消息交给消息代理，再由消息代理广播给所有连接的客户端
        registry.enableSimpleBroker("/queue");
        //表示配置一个或多个前缀，通过这些前缀过滤需要被controll层注解方法来处理的消息
        registry.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //连接点
        registry.addEndpoint("/singleChat").withSockJS();//前端使用sockjs
    }
}