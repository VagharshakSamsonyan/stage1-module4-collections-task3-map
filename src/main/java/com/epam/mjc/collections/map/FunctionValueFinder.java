package com.epam.mjc.collections.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FunctionValueFinder {
    public boolean isFunctionValuePresent(List<Integer> sourceList, int requiredValue) {
        Map<Integer, Integer> functionMap = calculateFunctionMap(sourceList);

        // Check if the required value is present among the function values
        return functionMap.containsValue(requiredValue);

    }

    private Map<Integer, Integer> calculateFunctionMap(List<Integer> sourceList) {
        Map<Integer, Integer> functionMap = new HashMap<>();

        for (Integer number : sourceList) {
            // Calculate the function value 5x + 2
            int functionValue = 5*number+2;

            // Put the number and its corresponding function value into the map
            functionMap.put(number, functionValue);
        }
        return functionMap;
    }

    public static void main(String[] args) {
        FunctionValueFinder finder = new FunctionValueFinder();
        List<Integer> sourceList = Arrays.asList(-1, 5, 4, 8);
        int requiredValue = 27;

        boolean isPresent = finder.isFunctionValuePresent(sourceList, requiredValue);
        System.out.println(isPresent);
    }
}
