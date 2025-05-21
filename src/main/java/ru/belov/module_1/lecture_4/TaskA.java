package ru.belov.module_1.lecture_4;

import java.util.HashMap;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pairQty = Integer.parseInt(sc.nextLine());
        HashMap<String, String> wordToSynonym = new HashMap<>();
        for (int i = 0; i < pairQty; i++) {
            String[] pair = sc.nextLine().split(" ");
            wordToSynonym.put(pair[0], pair[1]);
            wordToSynonym.put(pair[1], pair[0]);
        }
        String word = sc.nextLine();
        System.out.println(wordToSynonym.get(word));
        sc.close();
    }
}
