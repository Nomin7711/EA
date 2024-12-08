package edu.miu.nomin.jpa;

public class Game {
    private Vehicle vehicle;
    public Game(){}
    public Game(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public void play(){
        System.out.println("Game started playing.");
        vehicle.move();
    }

}
