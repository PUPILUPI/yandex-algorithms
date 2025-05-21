package ru.belov.module_1.lecture_1;

import java.util.Scanner;

public class TaskD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = Integer.parseInt(sc.nextLine());
        int b = Integer.parseInt(sc.nextLine());
        int c = Integer.parseInt(sc.nextLine());

        if (c < 0) {
            System.out.println("NO SOLUTION");
        } else if (a == 0 && b < 0) {
            System.out.println("NO SOLUTION");
        } else if (a == 0 && b != Math.pow(c, 2)) {
            System.out.println("NO SOLUTION");
        } else if (a == 0 && b == Math.pow(c, 2)) {
            System.out.println("MANY SOLUTIONS");
        } else {
            double x = (Math.pow(c, 2) - b) / a;
            if (x - Math.floor(x) < 1e-6) {
                System.out.println((int) x);
            } else {
                System.out.println("NO SOLUTION");
            }
        }

        sc.close();
    }
}
