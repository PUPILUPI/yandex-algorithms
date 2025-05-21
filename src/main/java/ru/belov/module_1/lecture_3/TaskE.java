package ru.belov.module_1.lecture_3;

import java.util.*;
import java.util.stream.Collectors;

public class TaskE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> numbers = Arrays.stream(sc.nextLine().split(" ")).collect(Collectors.toList());
        Set<String> allowedDigits= new HashSet<>(numbers);
        Set<String> digitsToAdd = new HashSet<>();
        String number = sc.nextLine();
        for (int i = 0; i < number.length(); i++) {
            if (!allowedDigits.contains(String.valueOf(number.charAt(i)))) {
                digitsToAdd.add(String.valueOf(number.charAt(i)));
            }
        }
        System.out.println(digitsToAdd.size());
        sc.close();
    }
}
