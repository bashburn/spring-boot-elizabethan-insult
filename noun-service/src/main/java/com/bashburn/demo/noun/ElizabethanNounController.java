package com.bashburn.demo.noun;

import com.bashburn.demo.words.WordSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ElizabethanNounController {
  private static final String DEFAULT_NOUN_FILE = "column3.txt";
  private final WordSource nounSource = new WordSource(DEFAULT_NOUN_FILE);

  @RequestMapping("/api/noun")
  public ResponseEntity<String> getNoun() {
    return new ResponseEntity<>(nounSource.generateWord(), HttpStatus.OK);
  }
}
