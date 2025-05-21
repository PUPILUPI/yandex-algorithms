package ru.belov.module_1.lecture_2;

import java.util.Scanner;

public class TaskI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int rowsQty = Integer.parseInt(input[0]);
        int columnsQty = Integer.parseInt(input[1]);
        int minesQty = Integer.parseInt(input[2]);
        String[][] square = new String[rowsQty][columnsQty];
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[i].length; j++) {
                square[i][j] = "0";
            }
        }
        for (int i = 0; i < minesQty; i ++) {
            String[] coordinates = sc.nextLine().split(" ");
            int row = Integer.parseInt(coordinates[0]) - 1;
            int col = Integer.parseInt(coordinates[1]) - 1;
            square[row][col] = "*";
            if (row  >= 1 ) {
                if (!square[row - 1][col].equals("*")) {
                    square[row - 1][col] = String.valueOf(
                            Integer.parseInt(square[row - 1][col]) + 1);
                }
                if (col >= 1 && !square[row - 1][col - 1].equals("*")) {
                    square[row - 1][col - 1] = String.valueOf(
                            Integer.parseInt(square[row - 1][col - 1]) + 1);
                }
                if (col < columnsQty - 1 && !square[row - 1][col + 1].equals("*")) {
                    square[row - 1][col + 1] = String.valueOf(
                            Integer.parseInt(square[row - 1][col + 1]) + 1);
                }
            }
            if (row < rowsQty - 1) {
                if (!square[row + 1][col].equals("*")) {
                    square[row + 1][col] = String.valueOf(
                            Integer.parseInt(square[row + 1][col]) + 1);
                }
                if (col >= 1 && !square[row + 1][col - 1].equals("*")) {
                    square[row + 1][col - 1] = String.valueOf(
                            Integer.parseInt(square[row + 1][col - 1]) + 1);
                }
                if (col < columnsQty - 1 && !square[row + 1][col + 1].equals("*")) {
                    square[row + 1][col + 1] = String.valueOf(
                            Integer.parseInt(square[row + 1][col + 1]) + 1);
                }
            }
            if (col < columnsQty - 1 && !square[row][col + 1].equals("*")) {
                square[row][col + 1] = String.valueOf(
                        Integer.parseInt(square[row][col + 1]) + 1);
            }
            if (col >= 1 && !square[row][col - 1].equals("*")) {
                square[row][col - 1] = String.valueOf(
                        Integer.parseInt(square[row][col - 1]) + 1);
            }
        }
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[i].length; j++) {
                System.out.print(square[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
