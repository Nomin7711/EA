package edu.miu.nomin.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component("game")
public class Game {
//    @Autowired
    @Qualifier("car1")
    private Car car;
//    @Autowired
    private Bike bike;

    public Game() {
        System.out.println("Game created");
    }

    public Game(Car car, Bike bike) {
        this.car = car;
        this.bike = bike;
    }
    public void setCar(Car car) {
        this.car = car;
    }
    public void setBike(Bike bike) {
        this.bike = bike;
    }

    public void play(){
        car.move();
        bike.move();
    }
}
