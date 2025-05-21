package ru.belov.module_1.lecture_3;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

public class TaskJWithTL {
    private static class Coordinate {
        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Coordinate)) return false;
            Coordinate other = (Coordinate) obj;
            return this.x == other.x && this.y == other.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] info = sc.nextLine().split(" ");
        int period = Integer.parseInt(info[0]);
        int maxDistance = Integer.parseInt(info[1]);
        int periodQty = Integer.parseInt(info[2]);
        HashSet<Coordinate> possibleCoordinates = new HashSet<>();
        possibleCoordinates.add(new Coordinate(0, 0));
        for (int i = 0; i < periodQty; i++) {
            String[] navigatorCoordinate = sc.nextLine().split(" ");
            int x = Integer.parseInt(navigatorCoordinate[0]);
            int y = Integer.parseInt(navigatorCoordinate[1]);
            possibleCoordinates = possibleCoordinates(possibleCoordinates, period);
            HashSet<Coordinate> navigatorPossibleCoordinates = new HashSet<>();
            navigatorPossibleCoordinates.add(new Coordinate(x, y));
            navigatorPossibleCoordinates = possibleCoordinates(navigatorPossibleCoordinates, maxDistance);
            possibleCoordinates = intersectCoordinates(possibleCoordinates, navigatorPossibleCoordinates);
        }
        System.out.println(possibleCoordinates.size());
        possibleCoordinates.forEach(coordinate -> System.out.println(coordinate.x + " " + coordinate.y));
    }
    private static HashSet<Coordinate> possibleCoordinates(HashSet<Coordinate> beginPossibleCoordinates, int maxDistance) {
        HashSet<Coordinate> possibleCoordinates = new HashSet<>();
        for (Coordinate coordinate: beginPossibleCoordinates) {
            for (int x = coordinate.x - maxDistance; x <= coordinate.x + maxDistance; x++) {
                for (int y = coordinate.y - maxDistance; y <= coordinate.y + maxDistance; y++) {
                    if (Math.abs(coordinate.x - x) + Math.abs(coordinate.y - y) <= maxDistance) {
                        possibleCoordinates.add(new Coordinate(x,y));
                    }
                }
            }
        }
        return possibleCoordinates;
    }
    private static HashSet<Coordinate> intersectCoordinates(HashSet<Coordinate> set1, HashSet<Coordinate> set2) {
        HashSet<Coordinate> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }


}
