package ru.belov.module_1.lecture_2;

import java.util.Arrays;
import java.util.Scanner;

public class TaskG {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        sc.close();
        int firstNegativeMin = 1;
        int secondNegativeMin = 1;
        int firstPositiveMax = -1;
        int secondPositiveMax = -1;

        for (int el: arr) {
            if (el < 0) {
                if (secondNegativeMin < el && el < firstNegativeMin) {
                    firstNegativeMin = el;
                } else if (el <= secondNegativeMin) {
                    firstNegativeMin = secondNegativeMin;
                    secondNegativeMin = el;
                }
            } else {
                if (firstPositiveMax < el && el < secondPositiveMax) {
                    firstPositiveMax = el;
                } else if (secondPositiveMax <= el) {
                    firstPositiveMax = secondPositiveMax;
                    secondPositiveMax = el;
                }
            }
        }


        if (firstPositiveMax >= 0 && firstNegativeMin < 0) {
            if ((long) firstPositiveMax * secondPositiveMax >= (long) firstNegativeMin * secondNegativeMin) {
                System.out.println(firstPositiveMax + " " + secondPositiveMax);
            } else {
                System.out.println(secondNegativeMin + " " + firstNegativeMin);
            }
        } else {
            if (firstNegativeMin == 1 && firstPositiveMax >= 0) {
                System.out.println(firstPositiveMax + " " + secondPositiveMax);
            } else if (firstPositiveMax == -1 && firstNegativeMin < 0) {
                System.out.println(secondNegativeMin + " " + firstNegativeMin);
            } else {
                System.out.println(secondNegativeMin + " " + secondPositiveMax);
            }
        }
    }
}