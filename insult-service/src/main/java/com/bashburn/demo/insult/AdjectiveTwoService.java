package com.bashburn.demo.insult;

import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AdjectiveTwoService {
  private static final HystrixCommandKey KEY = HystrixCommandKey.Factory.asKey("AdjectiveTwoService");
  private final String adjectiveTwoHost = System.getProperty("adjective.two.host", "http://adjective-two-service:8080");
  private final RestTemplate restTemplate = new RestTemplate();

  @HystrixCommand(commandKey = "AdjectiveTwoService",
    fallbackMethod = "getFallbackAdjective",
    commandProperties = {
      @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100")
    })
  public String getAdjectiveTwo() {
    return restTemplate.getForObject(adjectiveTwoHost + "/api/adjective", String.class);
  }

  public String getFallbackAdjective() {
    return "non-distributed";
  }
}
