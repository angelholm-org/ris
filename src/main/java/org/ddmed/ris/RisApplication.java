package org.ddmed.ris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class RisApplication {

    public static void main(String[] args) {
        SpringApplication.run(RisApplication.class, args);
    }

}
