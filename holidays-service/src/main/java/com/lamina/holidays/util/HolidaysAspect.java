package com.lamina.holidays.util;

import com.lamina.holidays.entity.Holiday;
import com.lamina.holidays.exception.HolidaysNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.List;

@Aspect
@Component
public class HolidaysAspect {
    private static final Logger logger = LogManager.getLogger(HolidaysAspect.class);

    @Around("execution(* com.lamina.holidays..*(..))")
    public Object profileAllMethods(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        final String methodName = signature.getName();
        final String className = signature.getDeclaringType().getName();

        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = point.proceed();
        stopWatch.stop();

        logger.info("Execution of ------->" + className + "." + methodName + ":::" + stopWatch.getTotalTimeMillis() + " ms");
        return result;
    }

    @Before(value = "execution(* com.lamina.holidays.service.HolidaysService.save(..)) && args(holiday)")
    public void beforePostHoliday(JoinPoint point, Holiday holiday) {
        logger.info("------------------- START save Holiday service ----------------");
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        System.out.println(methodSignature.getDeclaringTypeName() + "." + methodSignature.getName());
        System.out.println(holiday.toString());
        logger.info("------------------- END save Holiday service  ----------------");
    }

    @After(value = "execution(* com.lamina.holidays.HolidaysController.create(..)) && args(holiday)")
    public void afterPostHoliday(JoinPoint point, Holiday holiday) {
        logger.info("------------------- START afterPostHoliday ----------------");
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        System.out.println(methodSignature.getDeclaringTypeName() + "." + methodSignature.getName());
        System.out.println(holiday.toString());
        logger.info("------------------- END afterPostHoliday ----------------");
    }

    @AfterReturning(value = "execution(* com.lamina.holidays.service.HolidaysService.getHolidays(..))", returning = "holidays")
    public void returnHolidays(JoinPoint joinPoint, List<Holiday> holidays) {
        logger.info("------------------- START getHolidays ----------------");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        logger.info(methodSignature.getDeclaringTypeName() + " :: " + methodSignature.getName());
        holidays.forEach(holiday -> logger.debug(holiday.toString()));
        logger.info("------------------- END getHolidays ----------------");
    }

    @AfterThrowing(value = "execution(* com.lamina.holidays.service.HolidaysService.get(..))", throwing = "exception")
    public void throwHolidayNotFoundException(JoinPoint joinPoint, HolidaysNotFoundException exception) {
        logger.info("------------------- START throwHolidayNotFoundException ----------------");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        logger.info(methodSignature.getDeclaringTypeName() + " :: " + methodSignature.getName());
        logger.error(exception.getMessage());
        logger.info("------------------- END throwHolidayNotFoundException ----------------");
    }
}
