package ru.belov.module_1.lecture_5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] info = sc.nextLine().split(" ");
        int symbolsQty = Integer.parseInt(info[0]);
        int maxRepeatQty = Integer.parseInt(info[1]);

        String str = sc.nextLine();
        int maxLen = 1;
        int right = 0;
        int len = 0;
        int startInd = 0;
        Map<Character, Integer> charToQty = new HashMap<>();
        for (int left = 0; left < symbolsQty; left++) {
            while (right < symbolsQty &&
                    charToQty.getOrDefault(str.charAt(right), 0) < maxRepeatQty) {

                charToQty.put(str.charAt(right),
                        charToQty.getOrDefault(str.charAt(right), 0) + 1);
                right++;
            }
            len = right - left;
            if (len > maxLen) {
                maxLen = len;
                startInd =left;
            }
            charToQty.computeIfPresent(str.charAt(left), (k, v) -> v - 1);
        }

        System.out.println(maxLen + " " + (startInd + 1));
    }
}
