package edu.miu.nomin.jpa.config;

import edu.miu.nomin.jpa.Bike;
import edu.miu.nomin.jpa.Game;
import edu.miu.nomin.jpa.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class SpringConfig {
        @Bean
        public Vehicle vehicle() {
            Bike bike = new Bike();
            bike.setBrand("Honda");
            bike.setTireSize(18);
//            return new Bike(18, "Honda");
            return bike;
        }
        @Bean(name = "game", initMethod = "init")
        public Game myGame(){
            return new Game(vehicle());


    }
}
