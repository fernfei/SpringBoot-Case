/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: RabbitHeadersConfig
 * Author:   Administrator
 * Date:     2020/1/20 11:20
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/1/20
 * @since 1.0.0
 */
@Configuration
public class RabbitHeaderConfig {
    public final static String HEADERSNAME = "fern_header";

    @Bean
    Queue queueName() {
        return new Queue("queue_name");
    }

    @Bean
    Queue queueAge() {
        return new Queue("queue_age");
    }

    @Bean
    HeadersExchange headersExchange() {
        return new HeadersExchange(HEADERSNAME, true, false);
    }

    @Bean
    Binding bindingName() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "哈哈哈");
        map.put("name", "嘤嘤嘤");
        //whereAny()map集合中匹配到一对key-value就过
        //还有WhereAll() 全部匹配到才过
        return BindingBuilder.bind(queueName()).to(headersExchange()).whereAny(map).match();
    }

    @Bean
    Binding bindingAge() {
        //return BindingBuilder.bind(queueAge()).to(headersExchange()).where("age").exists();这个匹配到age就直接通过
        return BindingBuilder.bind(queueAge()).to(headersExchange()).where("age").matches("呜呜呜");//这种则是key-value同时匹配到
    }
}