package edu.miu.nomin.jpa;

public class Car implements Vehicle {

    public Car(){}
    @Override
    public void move() {
        System.out.println("Car is moving");
    }
}
