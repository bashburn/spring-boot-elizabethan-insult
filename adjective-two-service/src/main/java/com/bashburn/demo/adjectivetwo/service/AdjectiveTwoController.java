package com.bashburn.demo.adjectivetwo.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicBoolean;

@RestController
public class AdjectiveTwoController {
  private final AdjectiveTwoSource source = new AdjectiveTwoSource();
  private final AtomicBoolean failSwitch = new AtomicBoolean(true);

  @RequestMapping("/api/adjective")
  public ResponseEntity<String> getAdjective() {
    if(failSwitch.get()) {
      String adjective = source.adjective();
      failSwitch.set(false);
      return new ResponseEntity<>(adjective, HttpStatus.OK);
    } else {
      failSwitch.set(true);
      return new ResponseEntity<>("We have blown up", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
