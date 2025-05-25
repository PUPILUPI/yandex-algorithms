package ru.belov.module_1.lecture_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TaskB {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] info = reader.readLine().split(" ");
        int firstArrLen = Integer.parseInt(info[0]);
        int secondArrLen = Integer.parseInt(info[1]);

        int[] firstArr = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] secondArr = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        StringBuilder output = new StringBuilder();
        for (int num : secondArr) {
            output.append(findApproximateNum(firstArr, num)).append("\n");
        }
        System.out.print(output);
    }

    private static int findApproximateNum(int[] arr, int num) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left < right) {
            mid = (right + left) / 2;
            if (check(arr[mid], num)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (left - 1 < 0) {
            return arr[left];
        }
        int res = Integer.compare(Math.abs(arr[left] - num),
                Math.abs(arr[left - 1] - num));
        if (res < 0) {
            return arr[left];
        } else if (res > 0){
            return arr[left - 1];
        }
        return Math.min(arr[left], arr[left - 1]);
    }

    private static boolean check(int int1, int int2) {
        return int1 >= int2;
    }
}
