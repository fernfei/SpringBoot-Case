/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: RabbitDirectConfig
 * Author:   Administrator
 * Date:     2020/1/19 8:49
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
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
public class RabbitDirectConfig {
    public final static String DIRECTNAME = "fern_direct";

    @Bean
    Queue queue() {
        //队列，存放着消息生成者发来的消息
        return new Queue("queue");
    }

   /* @Bean
    DirectExchange directExchange() {
        //durable是重启后是否依然有效，autoDelete长期没有使用是否删除掉
        return new DirectExchange(DIRECTNAME, true, false);

    }

    @Bean
    Binding binding() {
        //将queue|队列和directExchange绑定在一起
        return BindingBuilder.bind(queue()).to(directExchange()).with("direct");
    }
*/

}