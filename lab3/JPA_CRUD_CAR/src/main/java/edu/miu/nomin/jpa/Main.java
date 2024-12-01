package edu.miu.nomin.jpa;

import edu.miu.nomin.jpa.entity.Car;
import edu.miu.nomin.jpa.entity.Person;
import edu.miu.nomin.jpa.service.CRUD_service;
//lab1 - CRUD
//lab2 - Write a program that will persist a Car having a relationship with a Person
//A Car has one Person that person is a driver
//A Car has one Person that person is an owner
//The owner knows the car they own
//The driver does not know the car they drive
public class Main {
    public static void main(String[] args) {

        Car car = new Car("Toyota", "Prius", 2015, 1200);

        Person owner = new Person("John");
        Person driver = new Person("Adam");

        car.setOwner(owner);
        car.setDriver(driver);
        owner.setCar(car);

        try(CRUD_service crud_service = new CRUD_service("MyPu")){
            crud_service.create(car);
            crud_service.create(owner);
            crud_service.create(driver);
            Car foundCar = crud_service.read(car.getId());
            System.out.println("Found Car: " + foundCar);

        } catch (Exception e){
            e.printStackTrace();
        }
        try (CRUD_service crud_service = new CRUD_service("MyPu")){
            car.setMake("Subaru");
            car.setYear(2010);
            car.setModel("Forester");
            Car updatedCar = crud_service.update(car);
            System.out.println("Updated Car: " + updatedCar);
//            crud_service.delete(updatedCar);
//            System.out.println("Deleted Car: " + updatedCar);
        }catch (Exception e){
            e.printStackTrace();
        }
//        System.out.println(System.getProperty("java.specification.version"));


    }
}
