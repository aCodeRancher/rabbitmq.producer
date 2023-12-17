package com.course.rabbitmq;

import com.course.rabbitmq.producer.PictureProducerTwo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private PictureProducerTwo pictureProducer;

    private final List<String> SOURCES = List.of("mobile", "web");

    private final List<String> TYPES = List.of("jpg", "png", "svg");

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

   @Override
   public void run (String... args) throws Exception{
        
   }

}