package ru.belov.module_1.lecture_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TaskAOwnStructure {
    private static class MySet {
        private int size;
        private int capacity;
        private ArrayList<Integer>[] buckets;

        public MySet() {
            size = 0;
            capacity = 2;
            buckets = new ArrayList[capacity];
            for (int i = 0; i < capacity; i++) {
                buckets[i] = new ArrayList<>();
            }
        }

        public void add(int el) {
            if (contains(el)) return;

            if (size >= capacity) {
                resize();
            }

            int index = Math.abs(el % capacity);
            buckets[index].add(el);
            size++;
        }

        public boolean contains(int el) {
            int index = Math.abs(el % capacity);
            return buckets[index].contains(el);
        }

        public int size() {
            return size;
        }

        private void resize() {
            capacity *= 2;
            ArrayList<Integer>[] newBuckets = new ArrayList[capacity];
            for (int i = 0; i < capacity; i++) {
                newBuckets[i] = new ArrayList<>();
            }

            for (ArrayList<Integer> bucket : buckets) {
                for (int el : bucket) {
                    int index = Math.abs(el % capacity);
                    newBuckets[index].add(el);
                }
            }
            buckets = newBuckets;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        sc.close();
        MySet set = new MySet();
        for (int el: arr) {
            set.add(el);
        }
        System.out.println(set.size);
    }
}
