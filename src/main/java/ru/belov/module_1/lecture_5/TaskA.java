package ru.belov.module_1.lecture_5;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int shirtsQty = Integer.parseInt(sc.nextLine());
        int[] shirtColour= Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int pantsQty = Integer.parseInt(sc.nextLine());
        int[] pantColour= Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int prev = 0;
        int min = Math.abs(shirtColour[0] - pantColour[0]);
        prev = min;
        int minShirt = 0, curShirt = 0;
        int minPant = 0, curPant = 0;
        while (curPant < pantsQty - 1 && curShirt < shirtsQty - 1) {
            if (Math.abs(pantColour[curPant + 1] - shirtColour[curShirt]) <= prev) {
                curPant++;
            } else {
                curShirt++;
            }
            prev = Math.abs(pantColour[curPant] - shirtColour[curShirt]);
            if (prev < min) {
                min = prev;
                minPant = curPant;
                minShirt = curShirt;
            }
        }
        for (int i = curPant + 1; i < pantsQty; i++) {
            prev = Math.abs(pantColour[i] - shirtColour[curShirt]);
            if (prev < min) {
                min = prev;
                minPant = i;
                minShirt = curShirt;
            }
        }
        for (int i = curShirt + 1; i < shirtsQty; i++) {
            prev = Math.abs(pantColour[curPant] - shirtColour[i]);
            if (prev < min) {
                min = prev;
                minShirt = i;
                minPant = curPant;
            }
        }
        System.out.println(shirtColour[minShirt] + " " + pantColour[minPant]);
    }
}
