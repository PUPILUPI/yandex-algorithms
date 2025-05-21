package ru.belov.module_1.lecture_5;

import java.util.*;
import java.util.stream.Collectors;

//итерируемся по кондиционерам и для каждого кондиционера по классам
public class TaskFTimeLimit3 {
    private static class Conditioner implements Comparable<Conditioner> {
        int cost;
        int power;

        public Conditioner(int power, int cost) {
            this.power = power;
            this.cost = cost;
        }

        @Override
        public int compareTo(Conditioner o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int classQty = Integer.parseInt(sc.nextLine());
        List<Integer> powers = new ArrayList<>(Arrays.stream(sc.nextLine().trim().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
        powers.sort(Comparator.naturalOrder());
        int conditionersQty = Integer.parseInt(sc.nextLine());
        List<Conditioner> conditioners = new ArrayList<>();
        for (int i = 0; i < conditionersQty; i++) {
            String[] conditioner = sc.nextLine().split(" ");
            int power = Integer.parseInt(conditioner[0]);
            int cost = Integer.parseInt(conditioner[1]);
            conditioners.add(new Conditioner(power, cost));
        }
        conditioners.sort(Comparator.naturalOrder());
        int classInd = 0;
        int sum = 0;
        for (Conditioner cond : conditioners) {
            while (classInd < classQty && cond.power >= powers.get(classInd)) {
                sum += cond.cost;
                classInd++;
            }
        }

        System.out.println(sum);
    }
}
