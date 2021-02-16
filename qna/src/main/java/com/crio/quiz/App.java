package com.crio.quiz;

import lombok.extern.log4j.Log4j2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import org.modelmapper.ModelMapper;


@SpringBootApplication
@Log4j2
public class App {

    public static void main(String[] args) {
        System.out.println("hello");
        SpringApplication.run(App.class, args);

    // TIP:MODULE_RESTAPI: If your server starts successfully,
    // you can find the following message in the logs.
        log.info("Congrats! Your Quiz server has started");

    }

    @Bean // Want a new obj every time
    @Scope("prototype")
    public ModelMapper modelMapper() {
      return new ModelMapper();
    }
    
}