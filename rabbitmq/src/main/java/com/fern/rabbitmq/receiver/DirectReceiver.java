/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: DirectReceive
 * Author:   Administrator
 * Date:     2020/1/19 9:38
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
public class DirectReceiver {
    @RabbitListener(queues = "queue")
    public void receive1(String msg) {
        System.out.println("handler1>>>>>>>>>>>>>>" + msg);
    }

}