/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: Test
 * Author:   Administrator
 * Date:     2019/12/30 18:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package org.sang.controller;

import redis.clients.jedis.Jedis;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/30
 * @since 1.0.0
 */
public class Test {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.21.130", 6379);
        if ("PONG".equals(jedis.ping())) {
            System.out.println("成功！！！");
        }else{
            System.out.println("失败！！！");
        }
    }

}