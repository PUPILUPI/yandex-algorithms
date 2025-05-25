package ru.belov.module_1.lecture_5;

import java.util.*;

public class TaskG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numQty = sc.nextInt(); // количество карточек
        int toK = sc.nextInt();    // множитель k
        int[] cards = new int[numQty];
        for (int i = 0; i < numQty; i++) {
            cards[i] = sc.nextInt();
        }

        TreeMap<Integer, Integer> cardToQty = new TreeMap<>();
        for (int card : cards) {
            cardToQty.put(card, cardToQty.getOrDefault(card, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(cardToQty.entrySet());
        int len = entries.size();
        long ans = 0;

        int r = 0;
        int duplicates = 0;

        for (int l = 0; l < len; l++) {
            int leftVal = entries.get(l).getKey();

            while (r < len && entries.get(r).getKey() <= (long) leftVal * toK) {
                int cnt = entries.get(r).getValue();
                if (cnt > 1) {
                    duplicates++;
                }
                r++;
            }

            int rangeLen = r - l;
            int countL = entries.get(l).getValue();

            if (countL > 1) {
                ans += (rangeLen - 1) * 3L;
                duplicates -= 1;
            }
            if (countL > 2) {
                ans += 1;
            }
            if (rangeLen >= 3) {
                ans += (long) (rangeLen - 1) * (rangeLen - 2) * 3;
            }
            ans += duplicates * 3L;
        }
        System.out.println(ans);
    }
}

