package ru.belov.module_1.lecture_3;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class TaskI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int studentsQty = Integer.parseInt(sc.nextLine());
        HashMap<String, Integer> languageToPersonWhoKnowQty = new HashMap<>();
        for (int i = 0; i < studentsQty; i++) {
            int studentLanguagesQty = Integer.parseInt(sc.nextLine());
            for (int j = 0; j < studentLanguagesQty; j++) {
                languageToPersonWhoKnowQty.compute(sc.nextLine(),
                        (k,v) -> v == null ? 1 : v + 1);
            }
        }
        Set<String> allKnownLanguages = languageToPersonWhoKnowQty.entrySet()
                .stream()
                .filter(pair -> pair.getValue() == studentsQty)
                .map(pair -> pair.getKey())
                .collect(Collectors.toSet());
        System.out.println(allKnownLanguages.size());
        allKnownLanguages.stream().forEach(language -> System.out.println(language));
        System.out.println(languageToPersonWhoKnowQty.size());
        languageToPersonWhoKnowQty.entrySet()
                .stream()
                .forEach(pair -> System.out.println(pair.getKey()));

    }
}
