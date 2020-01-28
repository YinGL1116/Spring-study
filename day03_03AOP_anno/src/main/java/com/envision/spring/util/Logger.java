package com.envision.spring.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 模拟日志工具类 提供一个公共方法
 */
@Component
@Aspect
public class Logger {

    //在切入点方法之前执行该方法
    @Pointcut("execution(* com.envision.spring.service.impl.*.*(..))")
    public void pointCut() {}

    //@Before("pointCut()")
    void beforePrintLog() {
        System.out.println("前置通知");
    }
    //@AfterReturning("pointCut()")
    void afterReturningPrintLog() {
        System.out.println("后置通知");
    }
    //@AfterThrowing("pointCut()")
    void afterThrowingPrintLog() {
        System.out.println("异常通知");
    }
    //@After("pointCut()")
    void afterPrintLog() {
        System.out.println("最终通知");
    }

    @Around("pointCut()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) {
        Object rtValue = null;
        try {
            System.out.println("before");
            Object[] args = joinPoint.getArgs();
            rtValue = joinPoint.proceed(args);
            System.out.println("after returning");
            return rtValue;
        } catch (Throwable throwable) {
            System.out.println("afterThrowing");
            throw new RuntimeException(throwable);
        } finally {
            System.out.println("after");
        }
    }
}
