package ru.belov.module_1.lecture_2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TaskB {
    public static void main(String[] args) {
        Set<String> types = new HashSet<>(Set.of(
                "CONSTANT", "ASCENDING", "WEAKLY ASCENDING",
                "DESCENDING", "WEAKLY DESCENDING"));
        boolean isAll = false;
        Scanner sc = new Scanner(System.in);
        int prev = Integer.parseInt(sc.nextLine());
        while (!isAll) {
            int cur = Integer.parseInt(sc.nextLine());
            if (cur == -2_000_000_000) {
                isAll = true;
            } else if (cur == prev) {
                types.remove("DESCENDING");
                types.remove("ASCENDING");
            } else if (cur > prev) {
                types.remove("DESCENDING");
                types.remove("WEAKLY DESCENDING");
                types.remove("CONSTANT");
            } else {
                types.remove("ASCENDING");
                types.remove("WEAKLY ASCENDING");
                types.remove("CONSTANT");
            }
            prev = cur;
        }
        if (types.isEmpty()) {
            System.out.println("RANDOM");
        } else if (types.contains("CONSTANT")){
            System.out.println("CONSTANT");
        } else {
            System.out.println(types.iterator().next());
        }
        sc.close();
    }
}
