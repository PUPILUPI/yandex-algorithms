package ru.belov.module_1.lecture_3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class TaskAHashSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> set = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
        System.out.println(set.size());
    }
}
