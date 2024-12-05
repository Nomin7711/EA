package edu.miu.nomin.jpa;

public class Car implements Vehicle{
    private int year;
    private String make;
    private String model;
    private int mileage;
    public Car() {
        System.out.println("Car created");
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public int getMileage() {
        return mileage;
    }
    public void setMileage(int mileage) {
        this.mileage = mileage;
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
