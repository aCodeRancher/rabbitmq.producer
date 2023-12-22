package com.course.rabbitmq;

import com.course.rabbitmq.producer.SpringEmployeeJsonProducer;
import com.course.rabbitmq.producer.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private SpringEmployeeJsonProducer producer;

   public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

   @Override
   public void run (String... args) throws Exception{

          var emp  = new Employee("emp-spring", null, LocalDate.now());

          producer.sendMessage(emp);
   }


}