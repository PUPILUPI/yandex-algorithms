package ru.belov.module_1.lecture_2;

import java.util.Arrays;
import java.util.Scanner;

public class TaskFNotWork {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        int[] seq = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        sc.close();

        int left, right;
        if (seq.length == 1) {
            System.out.println(0);
            return;
        }
        else if (seq.length % 2 == 0) {
            left = seq.length / 2 - 1;
            right = left + 1;
        } else {
            left = seq.length / 2 - 1;
            right = seq.length / 2 + 1;
        }
         while (right != seq.length) {
             if (seq[right] == seq[left]) {
                 left--;
                 right++;
             } else {
                 if (seq[right - 1] == seq[right]) {
                     left = right - 1;
                 } else {
                     left = right;
                 }
                 left--;
                 right++;
             }
         }

         if (left == -1) {
             System.out.println(0);
         } else {
             System.out.println(left + 1);
             StringBuilder sb = new StringBuilder();
             for (int i = left; i != 0; i--) {
                 sb.append(seq[i]);
                 sb.append(" ");
             }
             sb.append(seq[0]);
             System.out.println(sb);
         }
    }
}
