package ru.belov.module_1.lecture_1;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int firstSide = Integer.parseInt(sc.nextLine());
        int secondSide = Integer.parseInt(sc.nextLine());
        int thirdSide = Integer.parseInt(sc.nextLine());
        if (firstSide + secondSide <= thirdSide
                || firstSide + thirdSide <= secondSide
                || secondSide + thirdSide <= firstSide) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
        sc.close();
    }
}
