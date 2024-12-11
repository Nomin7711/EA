package edu.miu.nomin.jpa;

public class Bike implements Vehicle {

    public Bike() {}
    @Override
    public void move() {
        System.out.println("Moving at 10mph.");
    }
}
