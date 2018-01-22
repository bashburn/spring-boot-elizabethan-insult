package com.bashburn.demo.insult;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ElizabethanNounController {
  private final AdjectiveService adjectiveService;
  private final ElizabethanNounSource nounSource;

  public ElizabethanNounController(final AdjectiveService adjectiveService) {
    this.adjectiveService = adjectiveService;
    this.nounSource = new ElizabethanNounSource();
  }

  @RequestMapping("/api/insult")
  public Insult getInsult() {
    String adjective = this.adjectiveService.getAdjective();
    String noun = this.nounSource.generateNoun();
    return new Insult(adjective, noun);
  }
}
