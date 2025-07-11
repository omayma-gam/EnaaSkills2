package org.example.apprenant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableFeignClients
public class ApprenantApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApprenantApplication.class, args);
    }

}
