package com.bashburn.demo.adjective.service;

import com.bashburn.demo.words.WordSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicBoolean;

@RestController
public class AdjectiveController {
  private final WordSource source = new WordSource("column1.txt");
  private final AtomicBoolean failSwitch = new AtomicBoolean(true);

  @RequestMapping("/api/adjective")
  public ResponseEntity<String> getAdjective() {
    if(failSwitch.get()) {
      String adjective = source.generateWord();
      failSwitch.set(false);
      return new ResponseEntity<>(adjective, HttpStatus.OK);
    } else {
      failSwitch.set(true);
      return new ResponseEntity<>("Adjective Service Down", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


}
