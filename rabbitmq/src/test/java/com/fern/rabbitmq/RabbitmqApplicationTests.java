package com.fern.rabbitmq;

import com.fern.rabbitmq.config.RabbitDirectConfig;
import com.fern.rabbitmq.config.RabbitFanoutConfig;
import com.fern.rabbitmq.config.RabbitHeaderConfig;
import com.fern.rabbitmq.config.RabbitTopicConfig;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Scanner;

@SpringBootTest
class RabbitmqApplicationTests {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Test
    void contextLoads() {
        //rabbitTemplate.convertAndSend(RabbitDirectConfig.DIRECTNAME,"direct","hello,rabbitmq!!!1");
        rabbitTemplate.convertAndSend("queue","hello,rabbitmq!!!1");
    }

    @Test
    void tset1() {
        rabbitTemplate.convertAndSend(RabbitFanoutConfig.FANOUTNAME,null,"hello RabbitMQ Fanout");
    }

    @Test
    void test2() {
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME, "xiaomi.d.e", "你好小米！");
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME, "huawei.cc", "你好华为！");
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME, "aa.iphone.bb", "你好苹果！");
    }

    @Test
    void test3() {

        Message msgName = MessageBuilder.withBody("hello name".getBytes()).setHeader("name", "嘤嘤嘤").build();
        Message msgAge = MessageBuilder.withBody("hello age".getBytes()).setHeader("age", "呜呜呜").build();
        rabbitTemplate.send(RabbitHeaderConfig.HEADERSNAME, null, msgName);
        rabbitTemplate.send(RabbitHeaderConfig.HEADERSNAME, null, msgAge);
    }
}
