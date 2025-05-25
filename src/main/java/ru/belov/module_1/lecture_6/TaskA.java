package ru.belov.module_1.lecture_6;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] info = sc.nextLine().split(" ");
        int firstArrLen = Integer.parseInt(info[0]);
        int secondArrLen = Integer.parseInt(info[1]);
        int[] firstArr = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] secondArr = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int num: secondArr) {
            if(findNum(firstArr, num)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean findNum(int[] arr, int num) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left < right) {
            mid = (right + left) / 2;
            if(arr[mid] == num) {
                return true;
            } else if (arr[mid] < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return arr[left] == num;
    }
}
