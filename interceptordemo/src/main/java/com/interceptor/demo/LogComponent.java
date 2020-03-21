/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: LogComponent
 * Author:   Administrator
 * Date:     2019/12/24 15:46
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.interceptor.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br>
 * 〈aop切面〉
 *
 * @author Administrator
 * @create 2019/12/24
 * @since 1.0.0
 */
@Component
@Aspect
public class LogComponent {
    @Pointcut("execution(* com.interceptor.service.*.*(..))")
    public void PC() {

    }

    @Before(value = "PC()")
    public void before(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println("before>>>>>>>>>>>" + name);
    }

    @After(value = "PC()")
    public void after(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println("after>>>>>>>>>>>" + name);
    }

    @AfterReturning(value = "PC()", returning = "result")
    public void afterReturnning(JoinPoint joinPoint, Object result) {
        String name = joinPoint.getSignature().getName();
        System.out.println("afterReturning>>>>>>>>>>>" + name + ">>>>>>>>>>>>" + result);
    }

    @AfterThrowing(value = "PC()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        String name = joinPoint.getSignature().getName();
        System.out.println("afterReturning>>>>>>>>>>>" + name + ">>>>>>>>>>>>" + e.getMessage());

    }

    @Around(value = "PC()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceed = joinPoint.proceed();

        return "我是环绕通知哦！！！";
    }
}