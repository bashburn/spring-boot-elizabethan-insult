package com.bashburn.demo.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileLoader {
  private static final Logger logger = Logger.getLogger(FileLoader.class.getName());

  public static List<String> loadFile(String filename) {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream(filename)))) {
      ArrayList<String> wordList = new ArrayList<>();
      while (reader.ready()) {
        wordList.add(reader.readLine().trim());
      }
      return wordList;
    } catch(IOException e) {
      logger.log(Level.SEVERE, "Error loading adjectives", e);
    }
    return Collections.emptyList();
  }
}
