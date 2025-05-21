package ru.belov.module_1.lecture_5;

import java.io.*;
import java.util.*;

public class TaskF {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] powers = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            powers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(powers);

        int m = Integer.parseInt(br.readLine());
        int[][] conditioners = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            conditioners[i][0] = Integer.parseInt(st.nextToken());
            conditioners[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(conditioners, (a, b) -> {
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        int sum = 0;
        int classInd = 0;
        for (int i = 0; i < m && classInd < n; i++) {
            int condPower = conditioners[i][0];
            int condCost = conditioners[i][1];
            while (classInd < n && condPower >= powers[classInd]) {
                sum += condCost;
                classInd++;
            }
        }

        System.out.println(sum);
    }
}

