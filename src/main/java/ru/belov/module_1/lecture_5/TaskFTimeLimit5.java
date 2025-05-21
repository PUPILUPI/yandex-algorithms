package ru.belov.module_1.lecture_5;

import java.util.*;

//убран класс кондиционер
public class TaskFTimeLimit5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[] powers = new int[n];
        String[] powerStrs = sc.nextLine().trim().split(" ");
        for (int i = 0; i < n; i++) {
            powers[i] = Integer.parseInt(powerStrs[i]);
        }
        Arrays.sort(powers);

        int m = Integer.parseInt(sc.nextLine());
        int[][] conditioners = new int[m][2];

        for (int i = 0; i < m; i++) {
            String[] parts = sc.nextLine().split(" ");
            conditioners[i][0] = Integer.parseInt(parts[0]);
            conditioners[i][1] = Integer.parseInt(parts[1]);
        }
        Arrays.sort(conditioners, (a, b) -> {
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        int sum = 0;
        int classInd = 0;
        for (int i = 0; i < m; i++) {
            int condPower = conditioners[i][0];
            int condCost = conditioners[i][1];
            while (classInd < n && condPower >= powers[classInd]) {
                sum += condCost;
                classInd++;
            }
        }

        System.out.println(sum);
    }
}
