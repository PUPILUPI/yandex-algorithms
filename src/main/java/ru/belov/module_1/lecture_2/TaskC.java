package ru.belov.module_1.lecture_2;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        int[] arr = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int point = Integer.parseInt(sc.nextLine());
        int answer = arr[0];
        int delta = Math.abs(point - answer);
        for (int el: arr) {
            int curDelta = Math.abs(point - el);
            if (curDelta < delta) {
                delta = curDelta;
                answer = el;
            }
        }
        System.out.println(answer);
        sc.close();
    }
}
