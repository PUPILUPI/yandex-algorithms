package ru.belov.module_1.lecture_1;

import java.util.Scanner;

public class TaskJ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = Double.parseDouble(sc.nextLine());
        double b = Double.parseDouble(sc.nextLine());
        double c = Double.parseDouble(sc.nextLine());
        double d = Double.parseDouble(sc.nextLine());
        double e = Double.parseDouble(sc.nextLine());
        double f = Double.parseDouble(sc.nextLine());
        System.out.println(calcAnswer(a, b, c, d, e, f));
        sc.close();
    }

    private static String calcAnswer(double a, double b, double c, double d, double e, double f) {
        if (a == 0 && b == 0 && c == 0 && d == 0 && e == 0 && f == 0) {
            return "5";
        } else if (a == 0 && c == 0 && b != 0 && d != 0 && Math.abs((e / b) - (f / d)) < 1e-6) {
            return 4 + " " + (e / b);
        } else if (a != 0 && c != 0 && b == 0 && d == 0 && Math.abs((e / a) - (f / c)) < 1e-6) {
            return 3 + " " + (e / a);
        } else if (a == 0 && b == 0 && e == 0) {
            if (c == 0) {
                return 4 + " " + (f / d);
            } else if (d == 0) {
                return 3 + " " + (f / c);
            } else {
                return 1 + " " + (-c / d) + " " + (f / d);
            }
        } else if (c == 0 && d == 0 && f == 0) {
            if (a == 0) {
                return 4 + " " + (e / b);
            } else if (b == 0) {
                return 3 + " " + (e / a);
            } else {
                return 1 + " " + (-a / b) + " " + (e / b);
            }
        } else if (Math.abs((e / b) - (f / d)) < 1e-6 && Math.abs((a / b) - (c / d)) < 1e-6) {
            return 1 + " " + (-a / b) + " " + (e / b);
        } else {
            double determinant = a * d - b * c;
            if (determinant != 0) {
                double x = (e * d - b * f) / determinant;
                double y = (a * f - e * c) / determinant;
                x = Math.round(x * 100000.0) / 100000.0;
                y = Math.round(y * 100000.0) / 100000.0;
                return 2 + " " + x + " " + y;
            } else return "0";
        }
    }
}
