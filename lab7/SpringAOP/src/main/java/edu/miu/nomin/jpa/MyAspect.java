package edu.miu.nomin.jpa;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class MyAspect implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        if(target instanceof Game) {
            Game game = (Game) target;
            Vehicle v = game.getVehicle();
            if (method.getName().equals("play")) {
                if (v instanceof Car) System.out.println("Car is moving.");
                else System.out.println("Bike is moving.");
            }
        }
    }

//    @Override
//    public void before(Method method, Object[] args, Object target) throws Throwable {
////        System.out.println(target.getClass());
//    }
}
