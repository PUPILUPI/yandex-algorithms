package ru.belov.module_1.lecture_5;

import java.util.*;

public class TaskE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] info = sc.nextLine().split(" ");
        int treeQty = Integer.parseInt(info[0]);
        int typesOfTreesQty = Integer.parseInt(info[1]);
        int[] trees = Arrays.stream(sc.nextLine().trim().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Map<Integer, Integer> treeToQty = new HashMap<>();
        int left = 0;
        int right = 1;
        int beginAnswer = 1;
        int endAnswer = 2;
        int minLength = treeQty;
        if (treeQty == typesOfTreesQty) {
            System.out.println("1 " + typesOfTreesQty);
            return;
        }
        treeToQty.put(trees[left], treeToQty.getOrDefault(trees[left], 0) + 1);
        treeToQty.put(trees[right], treeToQty.getOrDefault(trees[right], 0) + 1);
        while (left < treeQty && right < treeQty) {
            if (treeToQty.size() == typesOfTreesQty) {
                if ((right - left + 1) <= minLength) {
                    beginAnswer = left + 1;
                    endAnswer = right + 1;
                    minLength = right - left + 1;
                }
                treeToQty.compute(trees[left], (k, v) -> v - 1 != 0 ? v - 1 : null);
                left++;
            } else if (treeToQty.size() < typesOfTreesQty) {
                right++;
                if (right < treeQty) {
                    treeToQty.put(trees[right], treeToQty.getOrDefault(trees[right], 0) + 1);
                }
            }
        }
        System.out.println(beginAnswer + " " + endAnswer);
    }

}

