package edu.miu.nomin.jpa;

import edu.miu.nomin.jpa.config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Game game = context.getBean("game", Game.class);
        game.play();
        ((AnnotationConfigApplicationContext) context).close();
    }
}