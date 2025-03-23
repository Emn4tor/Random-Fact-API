package de.emn4tor.managers;

/*
 *  @author: Emn4tor
 *  @created: 23.03.2025
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class FactHandler {
    public static String getFact(String category) throws IOException {
        Map<String, String> factTypes = new HashMap<>();
        factTypes.put("animals", "facts/animals.txt");
        factTypes.put("history", "facts/history.txt");
        factTypes.put("science", "facts/science.txt");
        factTypes.put("space", "facts/space.txt");
        factTypes.put("technology", "facts/technology.txt");
        factTypes.put("random", "facts/random.txt");

        String filename = factTypes.get(category);
        if (filename == null) {
            return "Unknown category.";
        }

        InputStream inputStream = FactHandler.class.getClassLoader().getResourceAsStream(filename);
        if (inputStream == null) {
            return "File not found: " + filename;
        }

        List<String> facts;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            facts = reader.lines().toList();
        }

        if (facts.isEmpty()) {
            return "No facts available in " + filename;
        }

        return facts.get(new Random().nextInt(facts.size()));
    }
}