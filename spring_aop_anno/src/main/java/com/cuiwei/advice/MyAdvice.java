package com.cuiwei.advice;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 *  * 通知类
 */
@Component
@Aspect //升级为切面类，配置切入点和通知的关系
public class MyAdvice {

    @Pointcut("execution(* com.cuiwei.Service.impl.AccountServiceImpl.*(..))")
    public void myPonit(){

    }

    @Before("MyAdvice.myPonit()")
    public void before(){
        System.out.println("前置方法执行了....");
    }

    @AfterReturning("MyAdvice.myPonit()")
    public void afterReturning(){
        System.out.println("后置方法执行了....");
    }
}
