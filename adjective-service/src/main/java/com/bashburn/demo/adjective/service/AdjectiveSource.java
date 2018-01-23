package com.bashburn.demo.adjective.service;

import com.bashburn.demo.util.FileLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

class AdjectiveSource {
  private final static Logger logger = Logger.getLogger(AdjectiveSource.class.getName());
  private static final String DEFAULT_ADJECTIVE_ONE_FILE = "column1.txt";
  private static final String DEFAULT_ADJECTIVE_TWO_FILE = "column2.txt";
  private final List<String> adjectiveOneList;
  private final List<String> adjectiveTwoList;
  private final Long randomSeed;
  private final Random random;

  AdjectiveSource() {
    this(new Random().nextLong(), DEFAULT_ADJECTIVE_ONE_FILE, DEFAULT_ADJECTIVE_TWO_FILE);
  }

  AdjectiveSource(long randomSeed, String firstAdjectiveFile, String secondAdjectiveFile) {
    this.randomSeed = randomSeed;
    adjectiveOneList = new ArrayList<>();
    adjectiveTwoList = new ArrayList<>();
    random = new Random(this.randomSeed);
    adjectiveOneList.addAll(FileLoader.loadFile(firstAdjectiveFile));
    adjectiveTwoList.addAll(FileLoader.loadFile(secondAdjectiveFile));
  }

  private String randomString(List<String> stringList) {
    return stringList.get(random.nextInt(stringList.size()));
  }

  String firstAdjective() {
    return randomString(adjectiveOneList);
  }

  String secondAdjective() {
    return randomString(adjectiveTwoList);
  }
}
