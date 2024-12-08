package edu.miu.nomin.jpa.config;

import edu.miu.nomin.jpa.Bike;
import edu.miu.nomin.jpa.Car;
import edu.miu.nomin.jpa.Game;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
//@ComponentScan(basePackages = "edu.miu.nomin.jpa")
public class SpringConfig {
    @Bean(name="car1")
    public Car car1(){
        return new Car();
    }
    @Bean(name="car2")
    @Lazy(true)
    public Car car2(){
        return new Car();
    }
    @Bean(name="bike")
    public Bike bike(){
        return new Bike();
    }
    @Bean(name="game")
    public Game game(@Qualifier("car2") Car car, Bike bike){
        //Constructor
//        Game game = new Game(car, bike);
        //Setter
        Game game = new Game();
        game.setCar(car);
        game.setBike(bike);
        return game;
    }
}
