package com.course.rabbitmq;

import com.course.rabbitmq.producer.SpringPictureProducer;
import com.course.rabbitmq.producer.entity.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;



@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private SpringPictureProducer producer;

    private final List<String> SOURCES = List.of("mobile", "web");

    private final List<String> TYPES = List.of("jpg", "png", "svg");

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

   @Override
   public void run (String... args) throws Exception{
            var p = new Picture();
             p.setName("Spring picture");
             p.setSize(9500);
             p.setSource("web");
             p.setType("jpg");
             producer.sendMessage(p);
        }
}

