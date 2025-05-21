package ru.belov.module_1.lecture_3;
import java.util.*;

public class TaskJOptimised {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int period = sc.nextInt();
        int maxDistance = sc.nextInt();
        int periodQty = sc.nextInt();

        // x + y: minPlus, maxPlus
        // x - y: minMinus, maxMinus
        int minPlus = 0, maxPlus = 0, minMinus = 0, maxMinus = 0;

        for (int i = 0; i < periodQty; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            // Расширяем текущие границы на период (куда могли дойти)
            minPlus -= period;
            maxPlus += period;
            minMinus -= period;
            maxMinus += period;

            // Получаем границы наблюдаемой точки с ошибкой
            int obsPlus = x + y;
            int obsMinus = x - y;

            int obsMinPlus = obsPlus - maxDistance;
            int obsMaxPlus = obsPlus + maxDistance;
            int obsMinMinus = obsMinus - maxDistance;
            int obsMaxMinus = obsMinus + maxDistance;

            // Пересекаем с текущими границами
            minPlus = Math.max(minPlus, obsMinPlus);
            maxPlus = Math.min(maxPlus, obsMaxPlus);
            minMinus = Math.max(minMinus, obsMinMinus);
            maxMinus = Math.min(maxMinus, obsMaxMinus);
        }

        // Проверим, остались ли возможные точки
        if (minPlus > maxPlus || minMinus > maxMinus) {
            System.out.println(0);
            return;
        }

        // Восстановим координаты (x, y) из (x + y) и (x - y)
        List<int[]> result = new ArrayList<>();
        for (int xpy = minPlus; xpy <= maxPlus; xpy++) {
            for (int xmy = minMinus; xmy <= maxMinus; xmy++) {
                if ((xpy + xmy) % 2 != 0) continue;
                int x = (xpy + xmy) / 2;
                int y = xpy - x;
                result.add(new int[]{x, y});
            }
        }

        System.out.println(result.size());
        for (int[] coord : result) {
            System.out.println(coord[0] + " " + coord[1]);
        }
    }
}
