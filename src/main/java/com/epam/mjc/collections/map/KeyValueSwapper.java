package com.epam.mjc.collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class KeyValueSwapper {
    public Map<String, Integer> swap(Map<Integer, String> sourceMap) {
        Map<String, Integer> resultMap = new HashMap<>();

        // Create a TreeMap to automatically sort keys
        TreeMap<String, Integer> sortedresultMap = new TreeMap<>();

        // Iterate through the entries of the source map
        for (Map.Entry<Integer,String> entry : sourceMap.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();

            // Check if the value already exists in the result map
            // If it does, only keep the smallest key
            if (resultMap.containsKey(value)) {
                Integer existingKey = resultMap.get(value);
                if (key < existingKey) {
                    resultMap.put(value, key);
                }
            } else {
                resultMap.put(value, key);
            }
        }
        // Swap keys and values
        for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
            sortedresultMap.put(entry.getKey(), entry.getValue());
        }
        return sortedresultMap;
    }

    public static void main(String[] args) {
        KeyValueSwapper swapper = new KeyValueSwapper();
        Map<Integer,String> sourceMap = new HashMap<>();
        sourceMap.put(1, "one");
        sourceMap.put(2, "two");
        sourceMap.put(3, "three");
        sourceMap.put(10, "ten");
        Map<String, Integer> swappedMap = swapper.swap(sourceMap);
        for (Map.Entry<String, Integer> entry : swappedMap.entrySet()) {
            System.out.println(entry.getKey()+" - " + entry.getValue());
        }
    }
}
