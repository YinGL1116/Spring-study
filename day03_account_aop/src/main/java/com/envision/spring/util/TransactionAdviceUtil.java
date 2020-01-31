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

    // 这里完全不必新写一个类 直接放到TransactionManager里面就可以了

    //使用环绕通知ok
    //如果使用四个通知类型  有一个很奇怪的坑是 会先执行after方法再执行after returning 或者after throwing 导致事务控制的失败
    //使用注解的方法 会出现上述问题 使用xml不会 xml顺序会严格按照设想
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
