package com.adventofcode.config;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static String readInput(String filename) throws IOException {
        List<String> lines = new ArrayList<>();
        // Locate the file inside the classpath
        Resource resource = new ClassPathResource("inputs/" + filename);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
                builder.append(line);
                builder.append("\n");
            }
        }
        return builder.toString();
    }
}
