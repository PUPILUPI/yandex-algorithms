package ru.belov.module_1.lecture_3;

import java.util.HashMap;
import java.util.Scanner;

public class TaskG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int turtleQty = Integer.parseInt(sc.nextLine());
        HashMap<Integer, Integer> behindQtyToFrontQty = new HashMap<>();
        int trueQty = 0;
        for (int i = 0; i < turtleQty; i++) {
            behindQtyToFrontQty.put(i, turtleQty - i - 1);
        }
        for (int i = 0; i < turtleQty; i++) {
            String[] statement = sc.nextLine().split(" ");
            int behindQty = Integer.parseInt(statement[0]);
            int frontQty = Integer.parseInt(statement[1]);
            if (behindQtyToFrontQty.containsKey(behindQty)
                    && behindQtyToFrontQty.get(behindQty) == frontQty) {
                trueQty++;
                behindQtyToFrontQty.remove(behindQty);
            }
        }
        System.out.println(trueQty);
    }
}
