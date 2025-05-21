package ru.belov.module_1.lecture_1;

import java.util.Scanner;

public class TaskH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int firstInterval = Integer.parseInt(sc.nextLine());
        int secondInterval = Integer.parseInt(sc.nextLine());
        int firstNumberOfTrains = Integer.parseInt(sc.nextLine());
        int secondNumberOfTrains = Integer.parseInt(sc.nextLine());
        System.out.println(calcAnswer(firstInterval, secondInterval, firstNumberOfTrains, secondNumberOfTrains));
        sc.close();
    }

    private static String calcAnswer(int firstInterval, int secondInterval, int firstNumberOfTrains, int secondNumberOfTrains) {
        int firstMinTime = firstNumberOfTrains + (firstNumberOfTrains - 1) * firstInterval;
        int secondMinTime = secondNumberOfTrains + (secondNumberOfTrains - 1) * secondInterval;
        int firstMaxTime = firstMinTime + 2 * firstInterval;
        int secondMaxTime = secondMinTime + 2 * secondInterval;
        int minTime = Math.max(firstMinTime, secondMinTime);
        int maxTime = Math.min(firstMaxTime, secondMaxTime);
        if (firstMinTime > secondMinTime) {
            if ((firstMinTime - secondMinTime) >= 2 * secondInterval + 1) {
                return "-1";
            }
        } else if (secondMinTime > firstMinTime) {
            if ((secondMinTime - firstMinTime) >= 2 * firstInterval + 1) {
                return "-1";
            }
        }
        return minTime + " " + maxTime;
    }
}
