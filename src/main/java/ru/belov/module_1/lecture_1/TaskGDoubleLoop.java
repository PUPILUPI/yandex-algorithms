package ru.belov.module_1.lecture_1;

import java.util.Arrays;
import java.util.Scanner;

public class TaskGDoubleLoop {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] info = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int weight = info[0];
        int pieceWeight = info[1];
        int partWeight = info[2];
        int qty = calculateQty(weight, pieceWeight, partWeight);
        System.out.println(qty);
        sc.close();

    }
    private static int calculateQty(int weight, int pieceWeight, int partWeight) {
        int balance = weight;
        int partQty = 0;
        if (partWeight > pieceWeight) {
            return partQty;
        }
        do {
            int pieceQty = balance / pieceWeight;
            balance %= pieceWeight;
            for (int i = 0; i < pieceQty; i++) {
                partQty += pieceWeight / partWeight;
                balance += pieceWeight % partWeight;
            }
        } while (balance >= pieceWeight);

        return partQty;

    }
}
