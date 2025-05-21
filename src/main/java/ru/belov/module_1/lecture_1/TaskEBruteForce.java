package ru.belov.module_1.lecture_1;

import java.util.Arrays;
import java.util.Scanner;

public class TaskEBruteForce {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] info = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int k1 = info[0];
        int m = info[1];
        int k2 = info[2];
        int p2 = info[3];
        int n2 = info[4];
        int p1 = -1, n1 = -1;
        for (int a = 1; a <= 1000000; a++) {
            int[] answer = check(k1, m, k2, p2, n2, a);
            if (answer[0] != -1) {
                if(p1 == -1) {
                    p1 = answer[0];
                    n1 = answer[1];
                }
                if(p1 != answer[0]) {
                    p1 = 0;
                }
                if(n1 != answer[1]) {
                    n1 = 0;
                }
            }
        }
        System.out.println(p1 + " " + n1);
        sc.close();
    }

    private static int[] get(int flatNo, int flatsOnFloor, int floors) {
        int floorsBefore = (flatNo - 1 ) / flatsOnFloor;
        int podezd = (floorsBefore / floors) + 1;
        int floor = (floorsBefore % floors) + 1;
        return new int[]{podezd, floor};
    }

    private static int[] check(int k1, int m, int k2, int p2, int n2, int flatsOnFloor) {
        int[] answer = get(k2, flatsOnFloor, m);
        if (answer[0] == p2 && answer[1] == n2) {
            return get(k1, flatsOnFloor, m);
        }
        return new int[]{-1, -1};
    }
}
