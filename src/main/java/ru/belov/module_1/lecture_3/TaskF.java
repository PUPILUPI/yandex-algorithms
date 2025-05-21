package ru.belov.module_1.lecture_3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String firstGenom = sc.nextLine();
        String secondGenomm = sc.nextLine();
        HashMap<String, Integer> similarPairsQty = new HashMap<>();
        for (int i = 0; i < secondGenomm.length() - 1; i++) {
            String subGenom = secondGenomm.substring(i, i + 2);
            similarPairsQty.put(subGenom, 0);
        }
        for (int i = 0; i < firstGenom.length() - 1; i++) {
            String subGenom = firstGenom.substring(i, i + 2);
            similarPairsQty.computeIfPresent(subGenom, (k, v) -> v + 1);
        }
        int similarQty = 0;
        for (Map.Entry<String, Integer> pair: similarPairsQty.entrySet()) {
            similarQty += pair.getValue();
        }
        System.out.println(similarQty);
    }
}
