package ru.belov.module_1.lecture_1;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] data = sc.nextLine().split(" ");
        int tRoom = Integer.parseInt(data[0]);
        int tCond = Integer.parseInt(data[1]);
        String mode = sc.nextLine();
        int res = switch (mode) {
            case "freeze" -> Math.min(tRoom, tCond);
            case "heat" -> Math.max(tRoom, tCond);
            case "auto" -> tCond;
            case "fan" -> tRoom;
            default -> throw new IllegalStateException("Unexpected value: " + mode);
        };
        System.out.println(res);
        sc.close();
    }
}
