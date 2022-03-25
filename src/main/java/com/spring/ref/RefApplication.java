package com.spring.ref;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class RefApplication {

  public static void main(String[] args) {
    SpringApplication.run(RefApplication.class, args);
  }

}
