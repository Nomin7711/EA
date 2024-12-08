package edu.miu.nomin.jpa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//        1- Using an aspect, only allow play to work if the vehicle type is Car. Solve this using AspectJ.
//
//        2- For both Car and Bike, log to the console "the car is moving" or "the bike is moving" depending on if it is a Car or Bike. This message should be printed after a call to the move() method. Solve this using Spring AOP.
//
//3- Write a class that can count the number of Spring beans that get created. You should be able to count all the beans being created. If the configuration has 2 singleton beans and 3 prototypes, but in main you get 5 prototypes then the counter should be 7.
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Game game = (Game) context.getBean("game");
        game.play();
    }
}