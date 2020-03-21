/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: QuartzConfig
 * Author:   Administrator
 * Date:     2020/3/4 17:36
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.quartz.config;

import com.fern.quartz.job.MySecondJob;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.*;

import java.util.Date;
import java.util.HashMap;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/4
 * @since 1.0.0
 */
@Configuration
public class QuartzConfig {
    /**
     * 无参的JobDetail
     * @return
     */
    @Bean
    MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean(){
        MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
        //定时任务的bean的名字，这是之所以可以写成“myFirstJob”是因为我们已经将它注册到Spring容器中去了，可以写成首字母小写的形式
        bean.setTargetBeanName("myFirstJob");
        //定时任务的方法
        bean.setTargetMethod("firstJob");
        return bean;
    }

    /**
     * 带参的JobDetail
     * @return
     */
    @Bean
    JobDetailFactoryBean jobDetailFactoryBean(){
        JobDetailFactoryBean bean = new JobDetailFactoryBean();
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "fern");
        //定时任务所需的参数
        bean.setJobDataAsMap(map);
        //bean
        bean.setJobClass(MySecondJob.class);
        return bean;
    }

    /**
     * 无参的Trigger触发器
     * @return
     */
    @Bean
    SimpleTriggerFactoryBean simpleTriggerFactoryBean(){
        SimpleTriggerFactoryBean bean = new SimpleTriggerFactoryBean();
        bean.setJobDetail(methodInvokingJobDetailFactoryBean().getObject());
        //开始的时间，立马开始
        bean.setStartTime(new Date());
        //2秒重复一次
        bean.setRepeatInterval(2000);
        //重复3次，如果不给参数代表一直重复下去
        bean.setRepeatCount(3);
        return bean;
    }

    /**
     * 带参的Trigger触发器
     * @return
     */
    @Bean
    CronTriggerFactoryBean cronTriggerFactoryBean(){
        CronTriggerFactoryBean bean = new CronTriggerFactoryBean();
        bean.setJobDetail(jobDetailFactoryBean().getObject());
        //每10秒触发一次
        bean.setCronExpression("0/10 * * * * ?");
        return bean;
    }

    @Bean
    SchedulerFactoryBean schedulerFactoryBean(){
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        //将Trigger触发器传入用于执行，可以传入一个或多个参数
        bean.setTriggers(simpleTriggerFactoryBean().getObject(), cronTriggerFactoryBean().getObject());
        return bean;
    }

}