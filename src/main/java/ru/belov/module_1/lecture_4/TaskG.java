package ru.belov.module_1.lecture_4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Long> personToBalance = new HashMap<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            String[] operation = line.split(" ");
            String action = operation[0];
            String name = operation[1];

            switch (action) {
                case "DEPOSIT" -> {
                    personToBalance.putIfAbsent(name, 0L);
                    personToBalance.computeIfPresent(name,
                        (k, v) -> v + Long.parseLong(operation[2]));
                }
                case "WITHDRAW" -> {
                    personToBalance.putIfAbsent(name, 0L);
                    personToBalance.computeIfPresent(name,
                        (k, v) -> v - Long.parseLong(operation[2]));
                }
                case "BALANCE" -> {
                    Long balance = personToBalance.get(name);
                    if (balance != null) {
                        System.out.println(balance);
                    } else {
                        System.out.println("ERROR");
                    }
                }
                case "TRANSFER" -> {
                    personToBalance.putIfAbsent(name, 0L);
                    String name2 = operation[2];
                    personToBalance.putIfAbsent(name2, 0L);
                    personToBalance.computeIfPresent(name,
                            (k, v) -> v - Long.parseLong(operation[3]));
                    personToBalance.computeIfPresent(name2,
                            (k, v) -> v + Long.parseLong(operation[3]));
                }
                case "INCOME" -> {
                    int percent = Integer.parseInt(name); // тут name на самом деле процент
                    income(personToBalance, percent);
                }
                default -> System.out.println("Unknown command: " + action);
            }
        }
        scanner.close();
    }

    private static void income(Map<String, Long> personToBalance, int percent) {
        for (Map.Entry<String, Long> pair : personToBalance.entrySet()) {
            Long balance = pair.getValue();
            if (balance > 0) {
                personToBalance.put(pair.getKey(), balance + balance * percent / 100);
            }
        }
    }
}
