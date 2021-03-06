package com.envision.spring.util;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 模拟日志工具类 提供一个公共方法
 */
public class Logger {

    //在切入点方法之前执行该方法
    void beforePrintLog() {
        System.out.println("前置通知");
    }
    void afterReturningPrintLog() {
        System.out.println("后置通知");
    }
    void afterThrowingPrintLog() {
        System.out.println("异常通知");
    }
    void afterPrintLog() {
        System.out.println("最终通知");
    }

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
