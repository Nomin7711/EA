package edu.miu.nomin.jpa;

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
    @Override
    public void move() {
        System.out.println("Moving Car at 50 mph");
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
