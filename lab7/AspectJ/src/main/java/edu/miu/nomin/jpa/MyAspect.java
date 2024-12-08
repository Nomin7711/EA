package edu.miu.nomin.jpa;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {
    @Around("execution(* edu.miu.nomin.jpa.Game.*())")
    public void after(ProceedingJoinPoint joinPoint) throws Throwable {
        Game game = (Game) joinPoint.getTarget();
        Vehicle v = game.getVehicle();
        if(v instanceof Car){
            joinPoint.proceed();
            v.move();
        } else {
            System.out.println("Not a Car");
        }
    }
}
