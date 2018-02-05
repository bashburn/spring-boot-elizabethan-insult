package com.bashburn.demo.insult;

public class Insult {
  private String adjective;
  private String adjectiveTwo;
  private String noun;
  private String combined;

  public Insult(String adjective, String adjectiveTwo, String noun) {
    this.adjective = adjective;
    this.adjectiveTwo = adjectiveTwo;
    this.noun = noun;
    this.combined = adjective + ", " + adjectiveTwo + " " + noun;
  }

  public String getAdjectiveTwo() {
    return adjectiveTwo;
  }

  public void setAdjectiveTwo(String adjectiveTwo) {
    this.adjectiveTwo = adjectiveTwo;
  }

  public String getAdjective() {
    return adjective;
  }

  public void setAdjective(String adjective) {
    this.adjective = adjective;
  }

  public String getNoun() {
    return noun;
  }

  public void setNoun(String noun) {
    this.noun = noun;
  }

  public String getCombined() {
    return combined;
  }

  public void setCombined(String combined) {
    this.combined = combined;
  }
}
