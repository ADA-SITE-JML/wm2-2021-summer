package ada.wm2.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class StudentAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* ada.wm2.aopdemo.service.*.*(..))")
    public void before(JoinPoint joinPoint){
        logger.info(" Student Service is called: {}", joinPoint);
    }

    @After("execution(* ada.wm2.aopdemo.service.*.*(..))")
    public void after(JoinPoint joinPoint){
        logger.info(" Student Service is finished: {}", joinPoint);
    }

    /*
    @Around("@annotation(ada.wm2.aopdemo.annotation.TimeTracker)")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        joinPoint.proceed();

        long timeTaken = System.currentTimeMillis() - startTime;
        logger.info("Time Taken by {} is {}", joinPoint, timeTaken);
    }
    */
}
