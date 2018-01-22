package com.bashburn.demo.insult;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
 had @EnableCircuitBreaker
public class InsultApplication {
  public static void main(String[] args) {
    SpringApplication.run(InsultApplication.class, args);
  }
}
