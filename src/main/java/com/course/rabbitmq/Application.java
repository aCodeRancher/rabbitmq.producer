package com.course.rabbitmq;

import com.course.rabbitmq.producer.HelloRabbitProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ThreadLocalRandom;


@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private HelloRabbitProducer helloRabbitProducer;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

   @Override
   public void run (String... args) throws Exception{
        helloRabbitProducer.sendHello("MyName " + ThreadLocalRandom.current().nextInt());
   }

}