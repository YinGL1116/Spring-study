package com.envision.spring.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TransactionAdviceUtil {

    @Autowired
    private TransactionManager manager;

    @Pointcut("execution(* com.envision.spring.service.impl.*.*(..))")
    public void pointcut(){

    }

    @Around("pointcut()")
    public Object aroundTransactionAdvice(ProceedingJoinPoint joinPoint){
        Object rt;
        try {
            manager.begin();
            Object[] args = joinPoint.getArgs();
            rt = joinPoint.proceed(args);
            manager.commit();
            return rt;
        } catch (Throwable throwable) {
            manager.rollback();
            throw new IllegalStateException(throwable);
        } finally {
            manager.release();
        }
    }
}
