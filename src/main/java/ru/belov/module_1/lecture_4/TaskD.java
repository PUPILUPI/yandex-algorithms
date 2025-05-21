package ru.belov.module_1.lecture_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TaskD {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> keyToClickBalance = new HashMap<>();
        int keysQty = Integer.parseInt(reader.readLine());
        String[] clickQtyPerKey = reader.readLine().split(" ");
        for (int i = 1; i <= keysQty; i++) {
            keyToClickBalance.put(i, Integer.parseInt(clickQtyPerKey[i - 1]));
        }
        int clickQty = Integer.parseInt(reader.readLine());
        String[] clickPerKey = reader.readLine().split(" ");
        for (String click: clickPerKey) {
            keyToClickBalance.computeIfPresent(Integer.parseInt(click),
                    (k, v) -> v - 1);
        }
        for (Map.Entry<Integer, Integer> pair : keyToClickBalance.entrySet()) {
            if (pair.getValue() < 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
