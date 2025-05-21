package ru.belov.module_1.lecture_3;

import java.util.HashSet;
import java.util.Scanner;

public class TaskD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;
        HashSet<String> uniqueStrings = new HashSet<>();
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            if (line.isBlank()) {
                continue;
            }
            String[] words = line.trim().split("\\s+");
            for (String word: words) {
                uniqueStrings.add(word);
            }
        }
        sc.close();
        System.out.println(uniqueStrings.size());
    }
}
