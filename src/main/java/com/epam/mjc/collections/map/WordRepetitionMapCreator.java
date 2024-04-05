package com.epam.mjc.collections.map;

import java.util.HashMap;
import java.util.Map;

public class WordRepetitionMapCreator {
    public Map<String, Integer> createWordRepetitionMap(String sentence) {
        Map<String, Integer> wordMap = new HashMap<>();

        // Split the sentence into words by whitespace
        String[] words = sentence.toLowerCase().split("\\s+");

        // Count the occurrences of each word
        for (String word : words) {
            // Remove any punctuation marks from the word
            word = word.replaceAll("[^a-zA-Z]", "");

            // Update the count in the map
            if (!word.isEmpty()) {
                wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
            }
        }
        return wordMap;
    }

    public static void main(String[] args) {
        WordRepetitionMapCreator creator = new WordRepetitionMapCreator();
        String sentence = "sentense in loWER caSE, SENTENCE IN UPper CAse.";
        Map<String, Integer> repetitionMap = creator.createWordRepetitionMap(sentence);

        // Print the word repetition map
        for (Map.Entry<String, Integer> entry : repetitionMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
