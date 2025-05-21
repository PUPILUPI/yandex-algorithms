package ru.belov.module_1.lecture_4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class TaskFTimeLimit {
    public static void main(String[] args) throws IOException {
        String fileContent = Files.readString(Paths.get("input.txt"));
        String[] lines = fileContent.split("\n");

        Map<String, Map<String, Long>> shopersGoods = new HashMap<>();

        for (String line : lines) {

            String[] parts = line.trim().split("\\s+");
            String shoper = parts[0];
            String product = parts[1];
            long quantity = Long.parseLong(parts[2]);

            Map<String, Long> goods = shopersGoods.get(shoper);
            if (goods == null) {
                goods = new HashMap<>();
                shopersGoods.put(shoper, goods);
            }

            goods.put(product, goods.getOrDefault(product, 0L) + quantity);
        }

        List<String> sortedShopers = new ArrayList<>(shopersGoods.keySet());
        Collections.sort(sortedShopers);

        StringBuilder sb = new StringBuilder(8192);
        for (String shoper : sortedShopers) {
            sb.append(shoper).append(":\n");
            Map<String, Long> goods = shopersGoods.get(shoper);
            List<String> sortedProducts = new ArrayList<>(goods.keySet());
            Collections.sort(sortedProducts);

            for (String product : sortedProducts) {
                sb.append(product).append(" ").append(goods.get(product)).append("\n");
            }
        }

        Files.writeString(Paths.get("output.txt"), sb.toString());
    }

}
