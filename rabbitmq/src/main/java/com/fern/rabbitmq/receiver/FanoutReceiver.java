/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: FanoutReceiver
 * Author:   Administrator
 * Date:     2020/1/19 12:26
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
 * @create 2020/1/19
 * @since 1.0.0
 */
@Component
public class FanoutReceiver {
    @RabbitListener(queues = "queue_one")
    public void receive1(String msg) {
        System.out.println("FanoutReceiver:receive1>>>>>>>>>" + msg);
    }
    @RabbitListener(queues = "queue_two")
    public void receive2(String msg) {
        System.out.println("FanoutReceiver:receive2>>>>>>>>>" + msg);
    }
}