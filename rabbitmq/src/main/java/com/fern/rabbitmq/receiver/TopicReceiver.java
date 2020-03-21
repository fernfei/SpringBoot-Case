/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: TopicReceiver
 * Author:   Administrator
 * Date:     2020/1/20 10:35
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/1/20
 * @since 1.0.0
 */
@Component
public class TopicReceiver {
    @RabbitListener(queues = "queue_xiaomi")
    public void receive1(String msg) {
        System.out.println("小米："+msg);
    }
    @RabbitListener(queues = "queue_huawei")
    public void receive2(String msg) {
        System.out.println("华为："+msg);
    }
    @RabbitListener(queues = "queue_iphone")
    public void receive3(String msg) {
        System.out.println("苹果："+msg);
    }
}