package ru.belov.module_1.lecture_2;


import java.util.Scanner;

public class TaskJ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int freqQty = Integer.parseInt(sc.nextLine());
        double prevFreq = Double.parseDouble(sc.nextLine());
        double minFreq = 30;
        double maxFreq = 4000;
        for (int i = 1; i < freqQty; i++) {
            String[] input = sc.nextLine().split(" ");
            double curFreq = Double.parseDouble(input[0]);
            String compareRes = input[1];
            double freq = (prevFreq + curFreq) / 2;
            if ( curFreq < prevFreq ) {
                if (compareRes.equals("further")) {
                   if (freq > minFreq) minFreq = freq;
                } else {
                   if (freq < maxFreq) maxFreq = freq;
                }
            } else if (curFreq > prevFreq){
                if (compareRes.equals("further")) {
                    if (freq < maxFreq) maxFreq = freq;
                } else {
                    if (freq > minFreq) minFreq = freq;
                }
            }
            prevFreq = curFreq;
        }
        System.out.println(minFreq + " " + maxFreq);
        sc.close();
    }
}
