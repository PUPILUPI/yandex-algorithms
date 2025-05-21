package ru.belov.module_1.lecture_4;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class TaskHTimeLimit {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String[] qtyInfo = scanner.nextLine().split(" ");
        int symbolQtyInWord = Integer.parseInt(qtyInfo[0]);
        int symbolQtyInLine = Integer.parseInt(qtyInfo[1]);
        String word = scanner.nextLine();
        HashMap<Character, Integer> wordFreq = new HashMap<>();
        for (char ch : word.toCharArray()) {
            wordFreq.put(ch, wordFreq.getOrDefault(ch, 0) + 1);
        }
        String line = scanner.nextLine();
        int includeFound = 0;
        HashMap<Character, Integer> maybeWordMap;
        for (int i = 0; i <= symbolQtyInLine - symbolQtyInWord; i++) {
            String maybeWord = line.substring(i, i + symbolQtyInWord);
            maybeWordMap = new HashMap<>();
            for (char ch : maybeWord.toCharArray()) {
                maybeWordMap.put(ch, maybeWordMap.getOrDefault(ch, 0) + 1);
            }
            if (wordFreq.equals(maybeWordMap)) {
                includeFound++;
            }
        }
        System.out.println(includeFound);
    }
}
