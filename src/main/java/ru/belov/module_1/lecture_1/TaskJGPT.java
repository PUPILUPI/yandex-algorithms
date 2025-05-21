package ru.belov.module_1.lecture_1;

import java.util.Scanner;

public class TaskJGPT {

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
        final double EPS = 1e-5;

        // 5. Любое (x, y) - решение
        if (Math.abs(a) < EPS && Math.abs(b) < EPS && Math.abs(c) < EPS && Math.abs(d) < EPS &&
                Math.abs(e) < EPS && Math.abs(f) < EPS) {
            return "5";
        }

        // 0. Нет решений
        if (Math.abs(a * d - b * c) < EPS && (Math.abs(e * d - b * f) >= EPS || Math.abs(a * f - c * e) >= EPS)) {
            return "0";
        }

        // 4. Прямая вида y = y0 (x — любое)
        if (Math.abs(a) < EPS && Math.abs(c) < EPS) {
            if (Math.abs(b) > EPS) {
                return "4 " + Math.round((e / b) * 100000.0) / 100000.0;
            } else if (Math.abs(d) > EPS) {
                return "4 " + Math.round((f / d) * 100000.0) / 100000.0;
            }
            return "0";
        }

        // 3. Прямая вида x = x0 (y — любое)
        if (Math.abs(b) < EPS && Math.abs(d) < EPS) {
            if (Math.abs(a) > EPS) {
                return "3 " + Math.round((e / a) * 100000.0) / 100000.0;
            } else if (Math.abs(c) > EPS) {
                return "3 " + Math.round((f / c) * 100000.0) / 100000.0;
            }
            return "0";
        }

        // 1. Бесконечно много решений вида y = kx + b
        if (Math.abs(a * d - b * c) < EPS) {
            double k, bConst;
            if (Math.abs(b) > EPS) {
                k = -a / b;
                bConst = e / b;
            } else if (Math.abs(d) > EPS) {
                k = -c / d;
                bConst = f / d;
            } else {
                return "0"; // Ошибка в логике, если дошли сюда
            }
            k = Math.round(k * 100000.0) / 100000.0;
            bConst = Math.round(bConst * 100000.0) / 100000.0;
            return "1 " + k + " " + bConst;
        }

        // 2. Единственное решение (метод Крамера)
        double determinant = a * d - b * c;
        if (Math.abs(determinant) > EPS) {
            double x = (e * d - b * f) / determinant;
            double y = (a * f - e * c) / determinant;
            x = Math.round(x * 100000.0) / 100000.0;
            y = Math.round(y * 100000.0) / 100000.0;
            return "2 " + x + " " + y;
        }

        return "0"; // Если что-то пропустили
    }
}
