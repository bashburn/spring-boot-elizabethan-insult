package com.bashburn.demo.adjectivetwo.service;

import com.bashburn.demo.util.FileLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

class AdjectiveTwoSource {
  private static final Logger logger = Logger.getLogger(AdjectiveTwoSource.class.getName());
  private static final String DEFAULT_FILENAME = "column2.txt";
  private final long randomSeed;
  private final Random random;
  private final List<String> adjectives;

  AdjectiveTwoSource() {
    this(new Random().nextLong(), DEFAULT_FILENAME);
  }

  AdjectiveTwoSource(long randomSeed, String filename) {
    this.randomSeed = randomSeed;
    this.random = new Random(this.randomSeed);
    adjectives = new ArrayList<>();
    adjectives.addAll(FileLoader.loadFile(filename));
  }

  String adjective() {
    return adjectives.get(random.nextInt(adjectives.size()));
  }
}
