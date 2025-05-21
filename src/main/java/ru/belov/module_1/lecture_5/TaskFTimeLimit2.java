package ru.belov.module_1.lecture_5;

import java.util.*;
import java.util.stream.Collectors;

//итерируемся по классам, и для каждого класса по кондиционерам
public class TaskFTimeLimit2 {
    private static class Conditioner implements Comparable<Conditioner> {
        int cost;
        int power;

        public Conditioner(int power, int cost) {
            this.power = power;
            this.cost = cost;
        }

        @Override
        public int compareTo(Conditioner o) {
            return Integer.compare(this.power, o.power);
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

        int sum = 0;
        int minCostSuitCondInd = 0;
        int firstPower = powers.get(0);
        for (int j = minCostSuitCondInd; j < conditionersQty; j++) {
            Conditioner cond = conditioners.get(j);
            if (cond.power >= firstPower) {
                minCostSuitCondInd = j;
                break;
            }
        }
        for (int j = minCostSuitCondInd + 1; j < conditionersQty; j++) {
            Conditioner cond = conditioners.get(j);
            if (cond.cost < conditioners.get(minCostSuitCondInd).cost) {
                minCostSuitCondInd = j;
            }
        }
        sum += conditioners.get(minCostSuitCondInd).cost;
        for (int i = 1; i < classQty; i++) {
            int power = powers.get(i);
            if (conditioners.get(minCostSuitCondInd).power >= power) {
                sum += conditioners.get(minCostSuitCondInd).cost;
                continue;
            }
            for (int j = minCostSuitCondInd; j < conditionersQty; j++) {
                Conditioner cond = conditioners.get(j);
                if (cond.power >= power) {
                    minCostSuitCondInd = j;
                    break;
                }
            }
            for (int j = minCostSuitCondInd + 1; j < conditionersQty; j++) {
                Conditioner cond = conditioners.get(j);
                if (cond.cost < conditioners.get(minCostSuitCondInd).cost) {
                    minCostSuitCondInd = j;
                }
            }

            sum += conditioners.get(minCostSuitCondInd).cost;
        }
        System.out.println(sum);

    }
}
