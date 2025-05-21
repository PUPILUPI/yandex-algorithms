package ru.belov.module_1.lecture_2;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        int[] seq = Arrays.stream(new Scanner(System.in).nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 1; i < seq.length; i ++) {
            if (seq[i] - seq[i - 1] < 1) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
