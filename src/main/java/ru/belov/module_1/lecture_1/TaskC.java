package ru.belov.module_1.lecture_1;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String numberToAdd = formatString(sc.nextLine());
        String firstNumber = formatString(sc.nextLine());
        String secondNumber = formatString(sc.nextLine());
        String thirdNumber = formatString(sc.nextLine());

        System.out.println(numberToAdd.equals(firstNumber) ? "YES" : "NO");
        System.out.println(numberToAdd.equals(secondNumber) ? "YES" : "NO");
        System.out.println(numberToAdd.equals(thirdNumber) ? "YES" : "NO");
        sc.close();
    }

    private static String formatString(String str) {
        str = str.replaceAll("\\+7", "8")
                .replaceAll("[-()]", "");
        return str.length() < 11 ? "8495" + str : str;
    }

}
