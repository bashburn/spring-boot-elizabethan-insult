package com.bashburn.demo.insult;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class ElizabethanNounSource {
  private static final Logger logger = Logger.getLogger(ElizabethanNounSource.class.getName());
  private static final String DEFAULT_NOUN_FILE = "column3.txt";
  private final List<String> nounList;
  private final Long randomSeed;
  private final Random random;

  ElizabethanNounSource() {
    this(new Random().nextLong(), DEFAULT_NOUN_FILE);
  }

  ElizabethanNounSource(long randomSeed, String nounFile) {
    this.randomSeed = randomSeed;
    this.random = new Random(this.randomSeed);
    this.nounList = new ArrayList<>();
    this.nounList.addAll(loadNounFile(nounFile));
  }

  private Collection<? extends String> loadNounFile(String filename) {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream(filename)))) {
      ArrayList<String> holder = new ArrayList<>();
      while(reader.ready()) {
        holder.add(reader.readLine().trim());
      }
      return holder;
    } catch (IOException e) {
      logger.log(Level.SEVERE, "Failed to load nouns", e);
    }
    return Collections.emptyList();
  }

  String generateNoun() {
    return nounList.get(random.nextInt(nounList.size()));
  }
}
