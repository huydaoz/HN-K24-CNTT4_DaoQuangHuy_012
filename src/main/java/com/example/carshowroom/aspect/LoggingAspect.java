package com.example.carshowroom.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect
{
    @Before(
            "execution(* com.example.carshowroom.service.impl.CarServiceImpl.create*(..)) || " +
                    "execution(* com.example.carshowroom.service.impl.CarServiceImpl.update*(..))"
    )
    public void logMethod(JoinPoint joinPoint)
    {
        System.out.println(
                "Method called: " +
                        joinPoint.getSignature().getName()
        );
    }
}