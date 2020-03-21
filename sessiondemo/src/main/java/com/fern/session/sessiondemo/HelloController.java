/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: HelloController
 * Author:   Administrator
 * Date:     2019/12/31 23:10
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.session.sessiondemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/31
 * @since 1.0.0
 */
@RestController
public class HelloController {
    @Value("${server.port}")
    private Integer port;

    @GetMapping("/set")
    public String set(HttpSession session) {
        session.setAttribute("HELLO", "HUFEI");
        return String.valueOf(port);
    }

    @GetMapping("/get")
    public String get(HttpSession session) {
        return session.getAttribute("HELLO").toString()+port;
    }
}