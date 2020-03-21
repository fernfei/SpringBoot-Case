package com.fern.activemq;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class ActivemqApplicationTests {
    @Autowired
    JmsComponent jmsComponent;
    @Test
    void contextLoads() {
        Message message = new Message();
        message.setContent("hello！！！");
        message.setDate(new Date());
        jmsComponent.send(message);
    }

}
