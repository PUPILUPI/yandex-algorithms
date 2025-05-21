package ru.belov.module_1.lecture_5;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertexQty = Integer.parseInt(sc.nextLine());
        int[][] prefSums = new int[vertexQty + 1][2];
        prefSums[0][0] = 0;
        prefSums[0][1] = 0;
        int prevHeight = 0;
        for (int i = 1; i <= vertexQty; i++) {
            String[] vertex = sc.nextLine().split(" ");
            int delta = Integer.parseInt(vertex[1]) - prevHeight;
            if (delta >= 0) {
                prefSums[i][0] = prefSums[i - 1][0] + delta;
                prefSums[i][1] = prefSums[i - 1][1];
            } else {
                prefSums[i][0] = prefSums[i - 1][0];
                prefSums[i][1] = prefSums[i - 1][1] + delta;
            }
            prevHeight = Integer.parseInt(vertex[1]);
        }
        int tracksQty = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < tracksQty; i++) {
            String[] track = sc.nextLine().split(" ");
            int begin = Integer.parseInt(track[0]);
            int end = Integer.parseInt(track[1]);
            if (end >= begin) {
                System.out.println(prefSums[end][0] - prefSums[begin][0]);
            } else {
                System.out.println(prefSums[end][1] - prefSums[begin][1]);
            }
        }
    }
}
