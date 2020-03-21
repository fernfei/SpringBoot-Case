/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: RabbitFindoutConfig
 * Author:   Administrator
 * Date:     2020/1/19 12:09
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/1/19
 * @since 1.0.0
 */
@Configuration
public class RabbitFanoutConfig {
    public final static String FANOUTNAME = "fern_fanout";

    @Bean
    Queue queueOne() {
        return new Queue("queue_one");
    }
    @Bean
    Queue queueTwo() {
        return new Queue("queue_two");
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUTNAME, true, false);
    }

    @Bean
    Binding bindingOne() {
        return BindingBuilder.bind(queueOne()).to(fanoutExchange());
    }

    @Bean
    Binding bindingTwo() {
        return BindingBuilder.bind(queueTwo()).to(fanoutExchange());
    }
}