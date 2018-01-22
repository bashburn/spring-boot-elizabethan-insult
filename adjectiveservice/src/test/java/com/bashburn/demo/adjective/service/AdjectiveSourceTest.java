package com.bashburn.demo.adjective.service;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

public class AdjectiveSourceTest {
  private static final long RANDOM_SEED = 1L;
  private static final String FIRST_ADJECTIVE = "roguish";
  private static final String SECOND_ADJECTIVE = "pottle-deep";
  private AdjectiveSource source;

  @Before
  public void setup() {
    source = new AdjectiveSource(RANDOM_SEED, "column1.txt", "column2.txt");
  }

  @Test
  public void testFirstAdjective() {
    String firstAdjective = source.firstAdjective();
    assertThat(firstAdjective, notNullValue());
    assertThat(firstAdjective, equalTo(FIRST_ADJECTIVE));
  }

  @Test
  public void testSecondAdjective() {
    String secondAdjective = source.secondAdjective();
    assertThat(secondAdjective, notNullValue());
    assertThat(secondAdjective, equalTo(SECOND_ADJECTIVE));
  }

}