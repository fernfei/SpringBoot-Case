/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: MySecondJob
 * Author:   Administrator
 * Date:     2020/3/4 17:33
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.quartz.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/4
 * @since 1.0.0
 */
@Component
public class MySecondJob extends QuartzJobBean {
    private String name;
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("my second job say hello" + name + ":" + new Date());
    }
}