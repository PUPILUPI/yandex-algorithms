package ru.belov.module_1.lecture_5;

import java.util.*;

//списки заменены на массивы, добавлена сортировка по мощности
public class TaskFTimeLimit4 {
    private static class Conditioner implements Comparable<Conditioner> {
        int power;
        int cost;

        public Conditioner(int power, int cost) {
            this.power = power;
            this.cost = cost;
        }

        @Override
        public int compareTo(Conditioner o) {
            if (this.cost != o.cost) {
                return Integer.compare(this.cost, o.cost);
            } else {
                return Integer.compare(this.power, o.power);
            }
        }
    }

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
        Conditioner[] conditioners = new Conditioner[m];
        for (int i = 0; i < m; i++) {
            String[] line = sc.nextLine().trim().split(" ");
            int power = Integer.parseInt(line[0]);
            int cost = Integer.parseInt(line[1]);
            conditioners[i] = new Conditioner(power, cost);
        }
        Arrays.sort(conditioners);

        int sum = 0;
        int classInd = 0;
        for (Conditioner cond : conditioners) {
            while (classInd < n && cond.power >= powers[classInd]) {
                sum += cond.cost;
                classInd++;
            }
        }

        System.out.println(sum);
    }
}
