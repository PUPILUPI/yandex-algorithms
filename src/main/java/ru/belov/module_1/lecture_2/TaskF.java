package ru.belov.module_1.lecture_2;

import java.util.Arrays;
import java.util.Scanner;

public class TaskF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        int[] seq = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        sc.close();

        boolean isFoundPalindrome = false;
        int left = 0;
        while (!isFoundPalindrome && left < seq.length) {
            if (isPalindrome(seq, left)) {
                isFoundPalindrome = true;
            } else {
                left++;
            }
        }
        System.out.println(left);

        if (left == 0) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = left - 1; i > 0; i--) {
            sb.append(seq[i]).append(" ");
        }
        sb.append(seq[0]);
        System.out.println(sb);
    }

    private static boolean isPalindrome(int[] seq, int left) {
        int right = seq.length - 1;
        while (left < right) {
            if (seq[left] != seq[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

