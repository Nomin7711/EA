package edu.miu.nomin.jpa.entity;

import jakarta.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue
    private long id;
    private String model;
    private String make;
    private int year;
    private int mileage;

    @OneToOne(cascade = CascadeType.PERSIST, mappedBy = "car")
    private Person owner;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Person driver;

    public Car(){}
    public Car(String model, String make, int year, int mileage) {
        this.model = model;
        this.make = make;
        this.year = year;
        this.mileage = mileage;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getMileage() {
        return mileage;
    }
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Person getDriver() {
        return driver;
    }

    public void setDriver(Person driver) {
        this.driver = driver;
    }
    public long getId() {
        return id;
    }
    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", make='" + make + '\'' +
                ", year=" + year +
                ", mileage=" + mileage +
                '}';
    }


}
