package ru.belov.module_1.lecture_2;

import java.util.Arrays;
import java.util.Scanner;

public class TaskD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int[] arr = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        sc.close();

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
