package com.bashburn.demo.insult;

import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NounService {
  private static final HystrixCommandKey KEY = HystrixCommandKey.Factory.asKey("NounService");
  private final String nounHost = System.getProperty("noun.host", "http://noun-service:8080");
  private final RestTemplate restTemplate = new RestTemplate();

  @HystrixCommand(commandKey = "NounService",
      fallbackMethod = "getFallbackNoun",
      commandProperties = {
          @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100")
      })
  public String getNoun() {
    return restTemplate.getForObject(nounHost + "/api/noun", String.class);
  }

  private String getFallbackNoun() {
    return "dimwit";
  }
}
