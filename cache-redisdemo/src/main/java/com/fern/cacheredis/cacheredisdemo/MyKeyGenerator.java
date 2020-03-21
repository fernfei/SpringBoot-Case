/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: MyKeyGenerator
 * Author:   Administrator
 * Date:     2020/1/9 20:50
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.cacheredis.cacheredisdemo;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/1/9
 * @since 1.0.0
 */
@Component
public class MyKeyGenerator implements KeyGenerator {

    @Override
    public Object generate(Object target, Method method, Object... params) {
        return method.getName()+"::"+ Arrays.toString(params);
    }
}