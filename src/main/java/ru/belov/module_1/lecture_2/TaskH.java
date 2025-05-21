package ru.belov.module_1.lecture_2;

import java.util.Arrays;
import java.util.Scanner;

public class TaskH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        sc.close();
        int countNotNegNumbers = 0;
        int countNegativeNumbers = 0;
        for (int el : arr) {
            if (el >= 0) {
                countNotNegNumbers++;
            } else {
                countNegativeNumbers++;
            }
        }
        if (countNotNegNumbers >= 2 && countNegativeNumbers >= 2) {
            int[] posNumInd = findTwoMaxPositiveNumbersInd(arr);
            int thirdPosNum = findMaxNumberExcludeRes(arr, posNumInd);
            int[] negNumInd = findTwoMaxNegativeNumbersInd(arr);
            int thirdNegNum = findMaxNumberExcludeRes(arr, negNumInd);
            if ((long) arr[posNumInd[0]] * arr[posNumInd[1]] * thirdPosNum
                    > (long) arr[negNumInd[0]] * arr[negNumInd[1]] * thirdNegNum) {
                System.out.println(arr[posNumInd[0]] + " " + arr[posNumInd[1]] + " " + thirdPosNum);
            } else {
                System.out.println(arr[negNumInd[0]] + " " + arr[negNumInd[1]] + " " + thirdNegNum);
            }

        } else if (countNotNegNumbers == 0) {
            int[] res = findThreeMaxNegNumbers(arr);
            System.out.println(res[0] + " " + res[1] + " " + res[2]);
        } else if (countNegativeNumbers <= 1 && countNotNegNumbers > 1) {
            int[] posNumInd = findTwoMaxPositiveNumbersInd(arr);
            int thirdPosNum = findMaxNumberExcludeRes(arr, posNumInd);
            System.out.println(arr[posNumInd[0]] + " " + arr[posNumInd[1]] + " " + thirdPosNum);
        } else if (countNegativeNumbers > 1 && countNotNegNumbers == 1 ) {
            int[] negNumInd = findTwoMaxNegativeNumbersInd(arr);
            int thirdNegNum = findMaxNumberExcludeRes(arr, negNumInd);
            System.out.println(arr[negNumInd[0]] + " " + arr[negNumInd[1]] + " " + thirdNegNum);
        }else {
            System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
        }
    }

    private static int[] findThreeMaxNegNumbers(int[] arr) {
        int first = 1, second = 1, third = 1;

        for (int val : arr) {
            if (first == 1 || val > first) {
                third = second;
                second = first;
                first = val;
            } else if (second == 1 || val > second) {
                third = second;
                second = val;
            } else if (third == 1 || val > third) {
                third = val;
            }
        }
        return new int[]{first, second, third};
    }

    private static int findMaxNumberExcludeRes(int[] arr, int[] resInd) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (i == resInd[0] || i == resInd[1]) continue;

            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    private static int[] findTwoMaxPositiveNumbersInd(int[] arr) {
        int firstPositiveMax = -1, firstPosInd = -1,
                secondPositiveMax = -1, secondPosInd = -1;

        for (int i = 0; i < arr.length; i++) {
            int el = arr[i];
            if (el < 0) {
                continue;
            }
            if (firstPositiveMax < el && el < secondPositiveMax) {
                firstPositiveMax = el;
                firstPosInd = i;
            } else if (secondPositiveMax <= el) {
                firstPositiveMax = secondPositiveMax;
                firstPosInd = secondPosInd;
                secondPositiveMax = el;
                secondPosInd = i;
            }
        }
        return new int[]{firstPosInd, secondPosInd};
    }

    private static int[] findTwoMaxNegativeNumbersInd(int[] arr) {
        int firstNegativeMin = 1, secondNegativeMin = 1,
                firstNegInd = -1, secondNegInd = -1;

        for (int i = 0; i < arr.length; i++) {
            int el = arr[i];
            if (el >= 0) {
                continue;
            }
            if (secondNegativeMin < el && el < firstNegativeMin) {
                firstNegativeMin = el;
                firstNegInd = i;
            } else if (el <= secondNegativeMin) {
                firstNegativeMin = secondNegativeMin;
                firstNegInd = secondNegInd;
                secondNegativeMin = el;
                secondNegInd = i;
            }
        }
        return new int[]{secondNegInd, firstNegInd};
    }
}
