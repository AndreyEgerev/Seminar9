package homework.Seminar3.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Aspect
@Component

public class ExceptionAspect {
    @Pointcut("@annotation(homework.Seminar3.aspect.RecoverException)")
    public void exceptionRec(){
    }

    @Around("exceptionRec()")
    public Object exceptionAspect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        RecoverException annotation =
                ((MethodSignature) proceedingJoinPoint.getSignature()).getMethod().getAnnotation(RecoverException.class);
        List<Class<? extends RuntimeException>> exceptions = List.of(annotation.noRecoverFor());
        try {
            return proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            log.info("Method {} call exception {} - {}", proceedingJoinPoint.getSignature(), e.getClass(), e.getMessage());
            for (Class<? extends RuntimeException> exceptionClass : exceptions) {
                if (exceptionClass.isAssignableFrom(e.getClass())) {
                    log.info("Throws exception {}", e.getClass());
                    throw e;
                }
            }
        }
        return null;

    }

}
