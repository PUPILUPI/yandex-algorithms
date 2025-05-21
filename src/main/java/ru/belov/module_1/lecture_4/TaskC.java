package ru.belov.module_1.lecture_4;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TaskC {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> wordToQty = new HashMap<>();
        String line = reader.readLine();
        int maxRepeatCount = 0;
        while (line != null && !line.isBlank()) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                wordToQty.compute(word, (k, v) -> v == null ? 1 : v + 1);
                if (wordToQty.get(word) > maxRepeatCount) {
                    maxRepeatCount = wordToQty.get(word);
                }
            }
            line = reader.readLine();
        }
        List<String> maxWords = new ArrayList<>();
        for (Map.Entry<String, Integer> pair:wordToQty.entrySet()) {
            if(pair.getValue() == maxRepeatCount) {
                maxWords.add(pair.getKey());
            }
        }
        Collections.sort(maxWords);
        System.out.println(maxWords.get(0));
    }
}
