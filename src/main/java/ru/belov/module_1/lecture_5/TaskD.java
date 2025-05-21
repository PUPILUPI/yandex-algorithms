package ru.belov.module_1.lecture_5;

import java.util.Arrays;
import java.util.Scanner;

public class TaskD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] info = sc.nextLine().split(" ");
        long monumentQty = Integer.parseInt(info[0]);
        long maxDistance = Integer.parseInt(info[1]);
        long[] distances = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToLong(Long::parseLong)
                .toArray();
        long count = 0;
        int left = 0;
        int right = 1;
        while (left < monumentQty && right < monumentQty) {
            if (distances[right] - distances[left] <= maxDistance) {
                right++;
            } else {
                count += monumentQty - right;
                left++;
            }
        }
        System.out.println(count);
    }
}
