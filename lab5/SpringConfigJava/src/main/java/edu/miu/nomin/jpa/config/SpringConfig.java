package edu.miu.nomin.jpa.config;

import edu.miu.nomin.jpa.Bike;
import edu.miu.nomin.jpa.Game;
import edu.miu.nomin.jpa.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(SpringConfig2.class)
public class SpringConfig {
    @Bean(name = "game", initMethod = "init", destroyMethod = "destroy")
    public Game myGame(Vehicle vehicle) {
        return new Game(vehicle);
    }
}
