/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: HeaderReceiver
 * Author:   Administrator
 * Date:     2020/1/20 11:44
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
public class HeaderReceiver {
    @RabbitListener(queues = "queue_name")
    public void receive1(byte[] msg) {
        System.out.println(new String(msg, 0, msg.length));
    }
    @RabbitListener(queues = "queue_age")
    public void receive2(byte[] msg) {
        System.out.println(new String(msg, 0, msg.length));
    }
}