package com.bashburn.demo.words;

import com.bashburn.demo.util.FileLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class WordSource {
  private static final Logger logger = Logger.getLogger(WordSource.class.getName());
  private final List<String> wordList;
  private final Long randomSeed;
  private final Random numberGenerator;

  public WordSource(String filename) {
    this(randomLong(), filename);
  }

  public WordSource(Long randomSeed, String filename) {
    this.randomSeed = randomSeed;
    this.numberGenerator = new Random(this.randomSeed);
    this.wordList = new ArrayList<>();
    this.wordList.addAll(FileLoader.loadFile(filename));
  }

  private static Long randomLong() {
    return new Random().nextLong();
  }

  public String generateWord() {
    return this.wordList.get(this.numberGenerator.nextInt(this.wordList.size()));
  }
}
