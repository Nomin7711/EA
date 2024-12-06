package edu.miu.nomin.jpa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //i gave control to Spring. Spring does Ioc and DI it created vehicle and car.
        //Spring created framework to work it with xml files. This is Spring Boot.
        //Config file won't create objects it's not a code it is a comment to say which to create. So does annotation.
        //Beans are Bike, Car, Game objects.
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Game game = (Game) context.getBean("game");
        game.play();
        System.out.println("Bean name is : " + game.getBeanName());
        ((ClassPathXmlApplicationContext) context).close();

    }
}