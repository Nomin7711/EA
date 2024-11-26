package edu.miu.nomin.jpa;

import edu.miu.nomin.jpa.entity.Car;
import edu.miu.nomin.jpa.service.CRUD_service;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Prius", 2015, 1200);
        try(CRUD_service crud_service = new CRUD_service("MyPu")){
            crud_service.create(car);
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
            crud_service.delete(updatedCar);
            System.out.println("Deleted Car: " + updatedCar);
        }catch (Exception e){
            e.printStackTrace();
        }
//        System.out.println(System.getProperty("java.specification.version"));


    }
}
