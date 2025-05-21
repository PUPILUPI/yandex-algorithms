package ru.belov.module_1.lecture_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TaskC {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] info = reader.readLine().split(" ");
        int anyaQty = Integer.parseInt(info[0]);
        int boryaQty = Integer.parseInt(info[1]);
        List<Integer> uniqueAnyaAndBorya = new ArrayList<>();
        Set<Integer> anyaNotBorya = new HashSet<>();
        List<Integer> boryaNotAnya = new ArrayList<>();

        for (int i = 0; i < anyaQty; i++) {
            anyaNotBorya.add(Integer.parseInt(reader.readLine()));
        }
        for (int i = 0; i < boryaQty; i++) {
            int el = Integer.parseInt(reader.readLine());
            if (anyaNotBorya.contains(el)) {
                anyaNotBorya.remove(el);
                uniqueAnyaAndBorya.add(el);
            } else {
                boryaNotAnya.add(el);
            }
        }

        List<Integer> sortedAnyaOnly = new ArrayList<>(anyaNotBorya);
        Collections.sort(uniqueAnyaAndBorya);
        Collections.sort(sortedAnyaOnly);
        Collections.sort(boryaNotAnya);

        System.out.println(uniqueAnyaAndBorya.size());
        printList(uniqueAnyaAndBorya);
        System.out.println(sortedAnyaOnly.size());
        printList(sortedAnyaOnly);
        System.out.println(boryaNotAnya.size());
        printList(boryaNotAnya);
    }

    private static void printList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }


}
