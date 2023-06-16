package com.br.rasplus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class RasplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(RasplusApplication.class, args);
    }

}
