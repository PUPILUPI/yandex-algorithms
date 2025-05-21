package ru.belov.module_1.lecture_3;

import java.io.*;
import java.util.*;

public class TaskCHashMap {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] info = reader.readLine().split(" ");
        int anyaQty = Integer.parseInt(info[0]);
        int boryaQty = Integer.parseInt(info[1]);

        Map<Integer, Integer> map = new HashMap<>(anyaQty + boryaQty);

        for (int i = 0; i < anyaQty; i++) {
            int x = Integer.parseInt(reader.readLine());
            map.put(x, 1);
        }

        for (int i = 0; i < boryaQty; i++) {
            int x = Integer.parseInt(reader.readLine());
            int status = map.getOrDefault(x, 0);
            if (status == 1) {
                map.put(x, 3); // был у Ани → теперь у обоих
            } else {
                map.put(x, 2); // был только у Бори
            }
        }

        List<Integer> both = new ArrayList<>();
        List<Integer> onlyAnya = new ArrayList<>();
        List<Integer> onlyBorya = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int status = entry.getValue();
            if (status == 3) {
                both.add(num);
            } else if (status == 1) {
                onlyAnya.add(num);
            } else if (status == 2) {
                onlyBorya.add(num);
            }
        }

        printSorted(both);
        printSorted(onlyAnya);
        printSorted(onlyBorya);
    }

    private static void printSorted(List<Integer> list) {
        Collections.sort(list);
        System.out.println(list.size());
        if (!list.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (int num : list) {
                sb.append(num).append(" ");
            }
            sb.setLength(sb.length() - 1);
            System.out.println(sb);
        } else {
            System.out.println();
        }



    }
}
