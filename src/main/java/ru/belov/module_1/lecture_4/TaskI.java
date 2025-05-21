package ru.belov.module_1.lecture_4;

import java.util.*;

public class TaskI {

    static Set<Character> uppercaseLetters = new HashSet<>();

    public static void main(String[] args) {
        for (char c = 'A'; c <= 'Z'; c++) {
            uppercaseLetters.add(c);
        }
        Map<String, List<Integer>> dict = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int dictWordsQty = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < dictWordsQty; i++) {
            String word = scanner.nextLine();
            dict.putIfAbsent(word.toLowerCase(), new ArrayList<>());
            List<Integer> wordMap = dict.get(word.toLowerCase());
            if (!wordMap.isEmpty()) {
                for (int j = 0; j < word.length(); j++) {
                    char ch = word.charAt(j);
                    if (uppercaseLetters.contains(ch)) {
                        wordMap.set(j, 1);
                    }
                }
            } else {
                for (int j = 0; j < word.length(); j++) {
                    char ch = word.charAt(j);
                    if (uppercaseLetters.contains(ch)) {
                        wordMap.add(j, 1);
                    } else {
                        wordMap.add(j, 0);
                    }
                }
            }
        }

        int mistakeCount = 0;
        String line = scanner.nextLine();
        for (String word : line.split(" ")) {
            if (word.isEmpty()) continue;
            if (countUpperChar(word) != 1) {
                mistakeCount++;
                continue;
            }
            if (dict.containsKey(word.toLowerCase())) {
                for (int i = 0; i < word.length(); i++) {
                    char ch = word.charAt(i);
                    if (uppercaseLetters.contains(ch)) {
                        if (dict.get(word.toLowerCase()).get(i) != 1) {
                            mistakeCount++;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(mistakeCount);
    }

    private static int countUpperChar(String word) {
        int count = 0;
        for (char ch : word.toCharArray()) {
            if (uppercaseLetters.contains(ch)) {
                count++;
            }
        }
        return count;
    }
}
