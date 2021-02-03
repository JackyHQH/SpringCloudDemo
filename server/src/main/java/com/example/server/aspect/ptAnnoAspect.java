package com.example.server.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ptAnnoAspect {

    @Pointcut("@annotation(com.example.server.aspect.ptTest)")
    private void ptAnnoAspect(){

    }
    @After("ptAnnoAspect()")
    private void doAfter() {
        //获取接入方法
        System.out.println("----------------------------------切面After");
    }

}
