package ru.belov.module_1.lecture_4;

import java.util.*;
import java.util.stream.Collectors;

public class TaskJ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] info = sc.nextLine().split("\\s+");
        int keyWordsQty = Integer.parseInt(info[0]);
        boolean isKeyWordSensToReg = info[1].equals("yes");
        boolean isIdsMayStartWithNum = info[2].equals("yes");
        Set<String> keyWords = new HashSet<>();
        HashMap<String, Long> ids = new HashMap<>();
        HashSet<Character> digitSet = new HashSet<>();
        for (char c = '0'; c <= '9'; c++) {
            digitSet.add(c);
        }

        for (int i = 0; i < keyWordsQty; i++) {
            if (isKeyWordSensToReg) {
                keyWords.add(sc.nextLine());
            } else {
                keyWords.add(sc.nextLine().toLowerCase());
            }
        }

        StringBuilder textBuilder = new StringBuilder();
        String line;
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            line = cleanString(line);
//            убрано так как мешало тестам, видимо где-то была пустая строка
//            с ним 6 тест, без него 47 тест валится
//            if (line.isBlank()) {
//                break;
//            }
            String[] words = line.split("\\s+");
            for (String word: words) {
                if (word.isBlank()) {
                    continue;
                }
                if (!isKeyWordSensToReg) {
                    word = word.toLowerCase();
                }
                if (keyWords.contains(word)) {
                    continue;
                }
                if (digitSet.contains(word.charAt(0))) {
                    if (!isIdsMayStartWithNum || isNumeric(word)) {
                        continue;
                    }
                }
                ids.put(word, ids.getOrDefault(word, 0L) + 1);
                textBuilder.append(word).append(" ");
            }
        }
        var maxPair = ids.entrySet().stream().max((Comparator.comparing(Map.Entry::getValue)));
        Set<String> maxIds = ids.entrySet().stream()
                .filter(entry -> entry.getValue() == maxPair.get().getValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        String text = textBuilder.toString();
        for (String word : text.split("\\s+")) {
            if (maxIds.contains(word)) {
                System.out.println(word);
                break;
            }
        }

    }

    private static String cleanString(String input) {
        return input.replaceAll("[^a-zA-Z0-9_]", " ");
    }

    private static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
}
