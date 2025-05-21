package ru.belov.module_1.lecture_2;

import java.util.Arrays;
import java.util.Scanner;

public class TaskE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        int[] lengths = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        sc.close();

        int recordIndex = 0;
        int record = lengths[0];
        for (int i = 1; i < lengths.length; i ++) {
            if (lengths[i] > record) {
                record = lengths[i];
                recordIndex = i;
            }
        }

        int vasyliyLength = 0;
        boolean isFindCorrectLength = false;
        for (int i = 1; i < lengths.length - 1; i++) {
            if (recordIndex < i 
                    && lengths[i] > lengths[i +1]
                    && lengths[i] % 10 == 5
                    && lengths[i] > vasyliyLength) {
                vasyliyLength = lengths[i];
                isFindCorrectLength = true;
            }
        }

        if (!isFindCorrectLength) {
            System.out.println(0);
            return;
        }

        int count = 1;
        for (int length: lengths) {
            if (vasyliyLength < length) {
                count++;
            }
        }

        System.out.println(count);
    }
}
