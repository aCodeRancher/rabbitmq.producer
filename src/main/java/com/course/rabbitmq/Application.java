package com.course.rabbitmq;

import com.course.rabbitmq.producer.FixedRateProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private FixedRateProducer producer;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

   @Override
   public void run (String... args) throws Exception{

   }

}