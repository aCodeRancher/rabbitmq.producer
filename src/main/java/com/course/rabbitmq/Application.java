package com.course.rabbitmq;

import com.course.rabbitmq.producer.FurnitureProducer;
import com.course.rabbitmq.producer.entity.Furniture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private FurnitureProducer furnitureProducer;

    private final List<String> COLORS = List.of("white", "red", "green");

    private final List<String> MATERIALS = List.of("wood", "plastic", "steel");

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
     public void run (String... args) throws Exception{
             for (int i=0;i<10;i++){
                  var furniture = new Furniture();
                  furniture.setName("Furniture " + i);
                  furniture.setColor(COLORS.get(i % COLORS.size()));
                  furniture.setMaterial(MATERIALS.get( i % MATERIALS.size()));
                  furniture.setPrice(i);

                 furnitureProducer.sendMessage(furniture);
             }
    }

}