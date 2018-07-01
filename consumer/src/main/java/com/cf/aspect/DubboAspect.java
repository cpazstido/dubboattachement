package com.cf.aspect;

import com.cf.annotations.MyAnnotation;
import com.cf.context.DubboContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class DubboAspect {
    @Pointcut("@annotation(com.cf.annotations.MyAnnotation)")
    public void dubboAspect() {
    }

    @Around("dubboAspect()")
    public Object interceptCompensableMethod(ProceedingJoinPoint pjp) throws Throwable {

        Object target = pjp.getTarget();

        String methodName = pjp.getSignature().getName();

        Method method = null;
        for (Method m : target.getClass().getMethods()) {
            if (m.getName().equals(methodName)) {
                method = m;
                break;
            }
        }

        if(method.getAnnotation(MyAnnotation.class)!=null){
            System.out.println("has annotation");
        }else{
            System.out.println("no annotation");
        }
        DubboContext.set("123");

        return pjp.proceed();
    }
}
