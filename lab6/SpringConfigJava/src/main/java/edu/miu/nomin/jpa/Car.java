package edu.miu.nomin.jpa;

import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

public class Car implements Vehicle{
    private int year;
    private String make;
    private String model;
    private int mileage;
    public Car() {
        System.out.println("Car created");
    }
    public Car(int year, String make, String model, int mileage) {
        this.year = year;
        this.make = make;
        this.model = model;
        this.mileage = mileage;
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
    public void move() {
        System.out.println("Moving Car at 50 mph");
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
