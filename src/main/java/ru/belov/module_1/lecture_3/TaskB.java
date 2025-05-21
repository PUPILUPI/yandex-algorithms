package ru.belov.module_1.lecture_3;

import java.util.*;
import java.util.stream.Collectors;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> firstSet = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
        Set<Integer> secondSet = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
        List<Integer> list = new ArrayList<>();
        for (int el: secondSet) {
            if (firstSet.contains(el)) {
                list.add(el);
            }
        }
        Collections.sort(list);
        for (int el: list) {
            System.out.println(el + " ");
        }
    }
}
