package ru.belov.module_1.lecture_1;

import java.util.Scanner;

public class TaskI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int brickLength = Integer.parseInt(sc.nextLine());
        int brickWidth = Integer.parseInt(sc.nextLine());
        int brickHeight = Integer.parseInt(sc.nextLine());
        int holeLength = Integer.parseInt(sc.nextLine());
        int holeWidth = Integer.parseInt(sc.nextLine());
        System.out.println(calcAnswer(brickLength,
                brickWidth, brickHeight, holeLength,
                holeWidth));
        sc.close();
    }

    private  static String calcAnswer(int brickLength, int brickWidth, int brickHeight, int holeLength, int holeWidth) {
        if ((brickLength <= holeLength && brickWidth <= holeWidth) ||
                (brickLength <= holeWidth && brickWidth <= holeLength) ||
                (brickLength <= holeLength && brickHeight <= holeWidth) ||
                (brickLength <= holeWidth && brickHeight <= holeLength) ||
                (brickWidth <= holeLength && brickHeight <= holeWidth) ||
                (brickWidth <= holeWidth && brickHeight <= holeLength)) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
