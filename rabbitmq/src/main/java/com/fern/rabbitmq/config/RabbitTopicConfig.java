/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: RabbitTopicConfig
 * Author:   Administrator
 * Date:     2020/1/20 10:24
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/1/20
 * @since 1.0.0
 */
@Configuration
public class RabbitTopicConfig {
    public final static String TOPICNAME = "fern_topic";
    @Bean
    Queue queue_xiaomi() {
        return new Queue("queue_xiaomi");
    }
    @Bean
    Queue queue_huawei() {
        return new Queue("queue_huawei");
    }
    @Bean
    Queue queue_iphone() {
        return new Queue("queue_iphone");
    }

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(TOPICNAME, true, false);
    }

    @Bean
    Binding binding_xiaomi() {
        return BindingBuilder.bind(queue_xiaomi()).to(topicExchange()).with("xiaomi.*.*");
    }
    @Bean
    Binding binding_huawei() {
        return BindingBuilder.bind(queue_huawei()).to(topicExchange()).with("huawei.#");
    }
    @Bean
    Binding binding_iphone() {
        return BindingBuilder.bind(queue_iphone()).to(topicExchange()).with("#.iphone.#");
    }
}