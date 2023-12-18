package com.course.rabbitmq;

import com.course.rabbitmq.producer.RetryPictureProducer;
import com.course.rabbitmq.producer.entity.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private RetryPictureProducer pictureProducer;

    private final List<String> SOURCES = List.of("mobile", "web");

    private final List<String> TYPES = List.of("jpg", "png", "svg");

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

   @Override
   public void run (String... args) throws Exception{
        for (int i=0;i<10;i++){
             var p  = new Picture();
             p.setName("Picture " + i);
             p.setSize(ThreadLocalRandom.current().nextLong(9001,10000));
             p.setSource(SOURCES.get(i % SOURCES.size()));
             p.setType(TYPES.get( i % TYPES.size()));
             pictureProducer.sendMessage(p);
        }
   }

}