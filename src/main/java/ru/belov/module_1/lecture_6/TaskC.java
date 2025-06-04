package ru.belov.module_1.lecture_6;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] info = sc.nextLine().split(" ");
        int w = Integer.parseInt(info[0]);
        int h = Integer.parseInt(info[1]);
        int n = Integer.parseInt(info[2]);

        double eps = 1e-3;
        long left = 1;
        long right = Long.MAX_VALUE;
        long midSquareSide;
        while (left < right) {
            midSquareSide = left + ((right - left) / 2);
            long horizontalQty = midSquareSide / w;
            long verticalQty = midSquareSide / h;
            if (horizontalQty - (double) n / verticalQty >= -eps) {
                right = midSquareSide;
            } else {
                left = midSquareSide + 1;
            }
        }
        System.out.println(left);
    }
}
