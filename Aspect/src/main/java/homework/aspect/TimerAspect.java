package homework.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Slf4j
@Aspect
@Component
public class TimerAspect {
    @Pointcut("@annotation(homework.Seminar3.aspect.Timer")
    public void timerExecMethod(){}

    @Pointcut("within(@homework.Seminar3.aspect.Timer *)")
    public void timerExecClass(){}

    @Around("timerExecClass() || timerExecMethod()")
    public Object executionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long begin = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis() - begin;
        log.info("method {} executing {}", joinPoint.getSignature(),end);
        return result;
    }

}
