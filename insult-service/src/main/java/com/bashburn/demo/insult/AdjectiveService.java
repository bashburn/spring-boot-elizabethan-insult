package com.bashburn.demo.insult;

import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AdjectiveService {
  private static final HystrixCommandKey KEY = HystrixCommandKey.Factory.asKey("AdjectiveService");
  private final String adjectiveHost = System.getProperty("adjective.host", "http://adjective-service:8080");
  private final RestTemplate restTemplate = new RestTemplate();

  @HystrixCommand(commandKey = "AdjectiveService", fallbackMethod = "getFallbackAdjective", commandProperties = {
      @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100")
  })
  public String getAdjective() {
    return restTemplate.getForObject(adjectiveHost + "/api/adjective", String.class);
  }

  private String getFallbackAdjective() {
    return "unconnected non-distributed";
  }
}
