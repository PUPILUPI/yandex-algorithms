package ru.belov.module_1.lecture_5;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class TaskG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] info = sc.nextLine().split(" ");
        int numQty = Integer.parseInt(info[0]);
        int toK = Integer.parseInt(info[1]);
        int[] cards = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        TreeMap<Integer, Integer> cardToQty = new TreeMap<>();
        for (int card : cards) {
            cardToQty.put(card, cardToQty.getOrDefault(card, 0) + 1);
        }

        int moreThenTwice = 0;
        int twice = 0;

        int right = 0;
        for (Map.Entry<Integer, Integer> card : cardToQty.entrySet()) {

        }
    }
}
