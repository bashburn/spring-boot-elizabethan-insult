package com.bashburn.demo.insult;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

public class ElizabethanNounSourceTest {
  private static final long RANDOM_SEED = 1L;
  private static final String ELIZABETHAN_NOUN = "moldwarp";
  private ElizabethanNounSource source;

  @Before
  public void setup() {
    source = new ElizabethanNounSource(RANDOM_SEED, "column3.txt");
  }

  @Test
  public void testGenerateNoun() {
    String noun = source.generateNoun();
    assertThat(noun, notNullValue());
    assertThat(noun, equalTo(ELIZABETHAN_NOUN));
  }

}