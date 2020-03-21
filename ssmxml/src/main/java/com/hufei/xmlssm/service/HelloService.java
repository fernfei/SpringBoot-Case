/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: HelloService
 * Author:   Administrator
 * Date:     2019/12/3 2:51
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hufei.xmlssm.service;

import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/3
 * @since 1.0.0
 */
@Service
public class HelloService {
    public String hello(){
        return "hello,world!!!";
    }
}