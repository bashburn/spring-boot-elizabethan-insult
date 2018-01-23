package com.bashburn.demo.adjectivetwo.service;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

public class AdjectiveTwoSourceTest {
  private static final long RANDOM_SEED = 1L;
  private static final String SECOND_ADJECTIVE = "pottle-deep";
  private AdjectiveTwoSource source;

  @Before
  public void setup() {
    source = new AdjectiveTwoSource(RANDOM_SEED, "column2.txt");
  }

  @Test
  public void testSecondAdjective() {
    String adjectiveTwo = source.adjective();
    assertThat(adjectiveTwo, notNullValue());
    assertThat(adjectiveTwo, equalTo(SECOND_ADJECTIVE));
  }

}