package ru.belov.module_1.lecture_4;

import java.util.*;

public class TaskH {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] qtyInfo = scanner.nextLine().split(" ");
        int symbolQtyInWord = Integer.parseInt(qtyInfo[0]);
        String word = scanner.nextLine();
        HashMap<Character, Integer> wordFreq = new HashMap<>();
        for (char ch : word.toCharArray()) {
            wordFreq.put(ch, wordFreq.getOrDefault(ch, 0) + 1);
        }
        String line = scanner.nextLine();
        int includeFound = 0;
        String maybeWord = line.substring(0, symbolQtyInWord);
        HashMap<Character, Integer> maybeWordMap = new HashMap<>();
        for (char ch : maybeWord.toCharArray()) {
            maybeWordMap.put(ch, maybeWordMap.getOrDefault(ch, 0) + 1);
        }
        if (maybeWordMap.equals(wordFreq)) {
            includeFound++;
        }
        for (int i = 0; i < line.length() - symbolQtyInWord; i++) {
            maybeWordMap.computeIfPresent(line.charAt(i), (k, value) -> {
                value -= 1;
                return value <= 0 ? null : value;
            });
            maybeWordMap.put(line.charAt(i + symbolQtyInWord),
                    maybeWordMap.getOrDefault(
                            line.charAt(i + symbolQtyInWord), 0) + 1);
            if (maybeWordMap.equals(wordFreq)) {
                includeFound++;
            }
        }

        System.out.println(includeFound);
    }
}

