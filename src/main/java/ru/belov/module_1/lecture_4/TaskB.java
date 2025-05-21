package ru.belov.module_1.lecture_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class TaskB {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        HashMap<String, Integer> wordToQty = new HashMap<>();
        while ((line = reader.readLine()) != null && !line.isEmpty()) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                wordToQty.compute(word, (k, v) -> {
                    if (wordToQty.containsKey(word)) {
                        System.out.print(wordToQty.get(word) + " ");
                        return v + 1;
                    } else {
                        System.out.print(0 + " ");
                        return 1;
                    }
                });
            }
        }
        reader.close();
    }
}
