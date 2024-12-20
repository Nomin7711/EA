package edu.miu.nomin.jpa.receiverjms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class ReceiverJmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReceiverJmsApplication.class, args);
    }

}
