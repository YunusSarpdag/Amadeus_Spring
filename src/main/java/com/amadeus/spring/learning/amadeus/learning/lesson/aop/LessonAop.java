package com.amadeus.spring.learning.amadeus.learning.lesson.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LessonAop {

  Logger logger = LoggerFactory.getLogger(LessonAop.class);
  @AfterThrowing(pointcut = "execution(* com.amadeus.spring.learning.amadeus.learning.lesson.controller.*.*(..))", throwing = "e")
  public void logErrors(Exception e) {
    logger.error("Exception logged amadeus: " + e.getMessage() + " " + e.getClass().getName());
  }


  @Before("execution(* com.amadeus.spring.learning.amadeus.learning.lesson.controller.*.*(..))")
  public void logBefore(JoinPoint joinPoint) {
    logger.info("Method called amadeus");
    logger.info("Method name amadeus: " + joinPoint.getSignature().getName());
  }
}
