package ru.belov.module_1.lecture_2;

import java.util.Scanner;


public class TaskIWithoutIf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int rowsQty = Integer.parseInt(input[0]);
        int columnsQty = Integer.parseInt(input[1]);
        int minesQty = Integer.parseInt(input[2]);
        int[][] square = new int[rowsQty + 2][columnsQty + 2];
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[i].length; j++) {
                square[i][j] = 0;
            }
        }
        for (int i = 0; i < minesQty; i++) {
            String[] coordinates = sc.nextLine().split(" ");
            int row = Integer.parseInt(coordinates[0]);
            int col = Integer.parseInt(coordinates[1]);
            square[row][col] = 100;

            square[row - 1][col]++;
            square[row - 1][col - 1]++;
            square[row - 1][col + 1]++;
            square[row + 1][col]++;
            square[row + 1][col - 1]++;
            square[row + 1][col + 1]++;
            square[row][col + 1]++;
            square[row][col - 1]++;
        }
        for (int i = 1; i < square.length - 1; i++) {
            for (int j = 1; j < square[i].length - 1; j++) {
                if (square[i][j] >= 100) {
                    System.out.print("* ");
                } else {
                    System.out.print(square[i][j] + " ");
                }
            }
            System.out.println();
        }
        sc.close();
    }
}

