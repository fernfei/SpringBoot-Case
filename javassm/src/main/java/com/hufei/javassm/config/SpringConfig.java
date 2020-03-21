/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: springConfig
 * Author:   Administrator
 * Date:     2019/12/5 23:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hufei.javassm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/5
 * @since 1.0.0
 */
@Configuration
@ComponentScan(basePackages = "com.hufei.javassm",useDefaultFilters = true,
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = Controller.class)})
public class SpringConfig {

}