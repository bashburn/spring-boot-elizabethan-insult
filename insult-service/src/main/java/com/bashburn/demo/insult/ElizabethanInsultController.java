package com.bashburn.demo.insult;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ElizabethanInsultController {
  private final AdjectiveService adjectiveService;
  private final AdjectiveTwoService adjectiveTwoService;
  private final NounService nounService;

  public ElizabethanInsultController(final AdjectiveService adjectiveService, final AdjectiveTwoService adjectiveTwoService, final NounService nounService) {
    this.adjectiveService = adjectiveService;
    this.adjectiveTwoService = adjectiveTwoService;
    this.nounService = nounService;
  }

  @RequestMapping("/api/insult")
  public Insult getInsult() {
    String adjective = this.adjectiveService.getAdjective();
    String adjectiveTwo = this.adjectiveTwoService.getAdjectiveTwo();
    String noun = this.nounService.getNoun();
    return new Insult(adjective, adjectiveTwo, noun);
  }
}
