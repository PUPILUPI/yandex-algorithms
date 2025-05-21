package ru.belov.module_1.lecture_1;

import java.util.Arrays;
import java.util.Scanner;

public class TaskGConst {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] info = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int weight = info[0];
        int pieceWeight = info[1];
        int partWeight = info[2];
        int qty = calculateQty(weight, pieceWeight, partWeight);
        System.out.println(qty);
        sc.close();
    }

    private static int calculateQty(int weight, int pieceWeight, int partWeight) {
        int partQty = 0;
        if (partWeight > pieceWeight) {
            return partQty;
        }
        int partQtyInPiece = pieceWeight / partWeight;
        int partQtyInPieceQtyInWeight = weight / (partWeight * partQtyInPiece);
        return weight - (partQtyInPieceQtyInWeight - 1) * (partWeight * partQtyInPiece) < pieceWeight ?
                (partQtyInPieceQtyInWeight - 1) * partQtyInPiece : partQtyInPieceQtyInWeight * partQtyInPiece;
    }

}
