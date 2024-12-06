package edu.miu.nomin.jpa;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public abstract class Game implements InitializingBean, BeanNameAware, DisposableBean {
    public String beanName;
    @Autowired
    private Car car;
    @Autowired
//    @Qualifier("bike1")
    private Bike bike;

    public Game() {
        System.out.println("Game created");
    }

    public String getBeanName() {
        return beanName;
    }
    @Override public void setBeanName(String s) {
        this.beanName= s;
    }
    public void play(){
        Vehicle vehicle = this.getVehicle();
        vehicle.move();
    }
    @Lookup
    public abstract Car getVehicle();
    private void init(){
        System.out.println("Initializing Game by default");
    }
    private void init2() {
        System.out.println("Initializing Game");
    }
    public void destroy_default(){
        System.out.println("Destroying Game by default");
    }
    @Override
    public void destroy() {
        System.out.println("Destroying Game");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        init2();
    }
}
