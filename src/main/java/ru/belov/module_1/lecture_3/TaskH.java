package ru.belov.module_1.lecture_3;
import java.util.HashSet;
import java.util.Scanner;

public class TaskH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int birdsQty = Integer.parseInt(sc.nextLine());
        HashSet<Integer> birdsColumns = new HashSet<>();
        for (int i = 0; i < birdsQty; i++) {
            String[] birdCoordinates = sc.nextLine().split(" ");
            birdsColumns.add(Integer.parseInt(birdCoordinates[0]));
        }
        System.out.println(birdsColumns.size());
    }
}
