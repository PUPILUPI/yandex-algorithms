package ru.belov.module_1.lecture_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TaskE {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int brickQty = Integer.parseInt(reader.readLine());
        HashMap<Integer, Integer> widthToHeight = new HashMap<>();
        for (int i = 0; i < brickQty; i++) {
            String[] brickSize = reader.readLine().split("\\s+");
            int width = Integer.parseInt(brickSize[0]);
            int height = Integer.parseInt(brickSize[1]);
            if (!widthToHeight.containsKey(width)) {
                widthToHeight.put(width, height);
            } else {
                if (widthToHeight.containsKey(width) && widthToHeight.get(width) < height) {
                    widthToHeight.put(width, height);
                }
            }
        }
        long height = 0;
        for (Map.Entry<Integer, Integer> pair : widthToHeight.entrySet()) {
            height += pair.getValue();
        }
        System.out.println(height);
    }
}

