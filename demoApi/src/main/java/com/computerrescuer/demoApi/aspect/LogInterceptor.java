package com.computerrescuer.demoApi.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogInterceptor {
  private final Logger logger;

  public LogInterceptor() {
      this.logger = LoggerFactory.getLogger(getClass());
  }
  
  @Before("execution(* com.computerrescuer.demoApi.*.*(..))")
  public void startLog(JoinPoint joinpoint){
    logger.info("start: " + joinpoint.getSignature());
  }

  @After("execution(* com.computerrescuer.demoApi.*.*(..))")
  public void endLog(JoinPoint joinpoint){
    logger.info("end  : " + joinpoint.getSignature());
  }

}
