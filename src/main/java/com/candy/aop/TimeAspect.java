package com.candy.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class TimeAspect {

    /**
     * 记录service层方法的执行耗时
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("execution(* com.candy.service.*.*(..))")
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        //1. 记录开始时间
        long begin = System.currentTimeMillis();

        //2. 调用要测试的方法
        Object result = joinPoint.proceed();

        //3. 记录结束时间, 计时总耗时
        long end = System.currentTimeMillis();
        log.info(joinPoint.getSignature() + "方法耗时:{}ms",end-begin);

        return result;

    }

}
