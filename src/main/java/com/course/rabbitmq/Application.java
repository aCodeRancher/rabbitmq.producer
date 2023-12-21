package com.course.rabbitmq;

import com.course.rabbitmq.producer.ReportRequestProducer;
import com.course.rabbitmq.producer.entity.ReportRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;


@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private ReportRequestProducer producer;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

   @Override
   public void run (String... args) throws Exception{
         for (int i=0; i<4;i++){
             var reportRequest = new ReportRequest();
             reportRequest.setReportName("Report "+i);
             reportRequest.setLarge(i % 2 == 0 ? true: false);

             producer.sendMessage(reportRequest);
         }
   }

}