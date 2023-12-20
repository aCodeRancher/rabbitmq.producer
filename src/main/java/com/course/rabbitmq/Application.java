package com.course.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;

@EnableScheduling
@SpringBootApplication
public class Application implements CommandLineRunner {



    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

   @Override
   public void run (String... args) throws Exception{

   }

}