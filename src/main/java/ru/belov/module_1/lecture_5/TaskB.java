package ru.belov.module_1.lecture_5;

import java.util.Arrays;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] info = sc.nextLine().split(" ");
        int numQty = Integer.parseInt(info[0]);
        int favoriteNum = Integer.parseInt(info[1]);
        int sum = 0;
        int left = 0;
        int right = 0;
        int count = 0;
        int[] ints = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        sum += ints[0];
        while (left < numQty && right < numQty) {
            System.out.print("left " + left + " ");
            System.out.print("sum " + sum + " ");
            System.out.println("right " + right);
            if (sum > favoriteNum) {
                sum -= ints[left];
                if (left == right) {
                    right++;
                    if (right < numQty) {
                        sum += ints[right];
                    }
                }
                left++;
            } else if (sum < favoriteNum) {
                right++;
                if (right < numQty) {
                    sum += ints[right];
                }
            } else {
                count++;
                right++;
                if (right < numQty) {
                    sum += ints[right];
                }
            }
        }
        System.out.println(count);
    }
}
