package com.spring.ref.config.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


/**
 * 실행순서
 * 1. around - start
 * 2. before
 * 3. after
 * 4. around - end
 */
@Slf4j
@Aspect
@Component
public class BaseAspect {


  @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
  public void getMapping(){}


  @Before("execution(* com.spring.ref.web..*(..))")
  public void before() {
    log.info("BaseAspect[before]");
  }

  @After("execution(* com.spring.ref.web..*(..))")
  public void after() {
    log.info("BaseAspect[after]");
  }

//  @Around("execution(* com.spring.ref.web..*(..))")
//  public Object requestResponseHandle(ProceedingJoinPoint joinPoint) throws Throwable {
//
//    log.info("BaseAspect[Around] start - " + joinPoint.getSignature().getDeclaringTypeName() + " / " + joinPoint.getSignature().getName());
//
//    Object result = joinPoint.proceed();
//
//    log.info("BaseAspect[Around] end - " + joinPoint.getSignature().getDeclaringTypeName() + " / " + joinPoint.getSignature().getName());
//    return result;
//  }
}
