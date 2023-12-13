package com.course.rabbitmq;

import com.course.rabbitmq.producer.HumanResourceProducer;
import com.course.rabbitmq.producer.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;


@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private HumanResourceProducer humanResourceProducer;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

   @Override
   public void run (String... args) throws Exception{
        for (int i=0;i<5;i++){
             var emp = new Employee("emp-" + i ,  "Employee "+ i, LocalDate.now());
             humanResourceProducer.sendMessage(emp);
        }
   }

}