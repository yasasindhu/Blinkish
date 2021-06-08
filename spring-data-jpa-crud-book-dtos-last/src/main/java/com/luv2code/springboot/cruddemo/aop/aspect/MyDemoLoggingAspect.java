package com.luv2code.springboot.cruddemo.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;




@Aspect
@Component
public class MyDemoLoggingAspect {


     private  static Logger myLogger= LoggerFactory.getLogger(MyDemoLoggingAspect.class);


    @After("execution( * com.luv2code.springboot.cruddemo.service.*.*(..))")
    public void forServicePackage( JoinPoint theJoinPoint)  {
        //print out method we are advising on
        String method=theJoinPoint.getSignature().toShortString();
        myLogger.info("\n ========>>>>Executing @After on method: "+method);

    }

}

