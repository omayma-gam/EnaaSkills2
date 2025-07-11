package org.example.commpetence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CommpetenceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommpetenceApplication.class, args);
    }

}
