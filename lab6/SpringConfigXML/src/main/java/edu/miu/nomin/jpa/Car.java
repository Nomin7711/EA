package edu.miu.nomin.jpa;

import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle, DisposableBean, BeanNameAware {
    private String beanName;
    private int year;
    private String make;
    private String model;
    private int mileage;
    public Car() {
        System.out.println("Car created");
    }

    public void setYear(int year) {
        System.out.println("Car year set");
        this.year = year;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @PreDestroy
    public void release(){
        System.out.println("Car released");
    }

    @Override
    public void move() {
        System.out.println("Moving Car at 50 mph");
        System.out.println(this.toString());
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Car destroyed");
    }

    @Override
    public String toString() {
        return "Car{" +
                "year=" + year +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", mileage=" + mileage +
                '}';
    }
}
