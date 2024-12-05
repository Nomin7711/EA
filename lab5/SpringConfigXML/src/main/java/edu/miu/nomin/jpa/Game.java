package edu.miu.nomin.jpa;

public class Game {
    private Vehicle vehicle;
    public Game() {}
    public Game(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public void play(){
        this.vehicle.move();
    }
    private void init() {
        System.out.println("Initializing Game");
    }

    private void destroy() {
        System.out.println("Destroying Game");
    }
}
