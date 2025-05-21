package ru.belov.module_1.lecture_1;

import java.util.*;

//работает только на первых 3ех примерах
public class TaskE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] info = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int findFlat = info[0];
        int floorQty = info[1];
        int givenFlat = info[2];
        int givenEntrance = info[3];
        int givenFloor = info[4];
        int findEntrance = -1, findFloor = -1;
        if (givenFloor == 1) {
            if (givenEntrance == 1) {
                findEntrance = 0;
                findFloor = floorQty == 1 ? 1 : 0;
                System.out.println(findEntrance + " " + findFloor);
                return;
            }
            if (givenFlat < floorQty * (givenEntrance - 1) + 1) {
                System.out.println("-1 -1");
                return;
            }
        }
        int flatsInEntrance = (givenFlat * floorQty) /
                (givenFloor - 1 + (givenEntrance - 1) * floorQty);
        int flatsPerFloor = flatsInEntrance / floorQty;
        flatsInEntrance = flatsPerFloor * floorQty;
        findEntrance = findFlat / flatsInEntrance + 1;
        findFloor = (findFlat - (findEntrance - 1) * flatsInEntrance) / flatsPerFloor + 1;
        System.out.println(findEntrance + " " + findFloor);
    }
}

