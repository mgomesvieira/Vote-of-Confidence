package com.michaelGV;

import java.util.ArrayList;

public class RanNoRep {
    private static ArrayList<Integer> selFrom;
    private static ArrayList<Integer> sel;

    public static ArrayList<Integer> genRanNoRep(int num, int from, int to) {
        selFrom = new ArrayList<Integer>(to - from + 1);
        sel = new ArrayList<Integer>(num);
        for (int i = 0; i < to - from + 1; i++) {
            selFrom.add(from + i);
        }
        for (int i = 0; i < num; i++) {
            int x = (int) (Math.random() * (to - from + 1 - i));
            int y = selFrom.get(x);
            selFrom.remove(x);
            sel.add(y);
        }
        return sel;
    }

    public static void main(String[] args) {
        int fin = 10;
            ArrayList<Integer> ran = genRanNoRep(6, 1, 49);
            for (int i = 0; i < 6; i++) {
                System.out.println(ran.get(i));
            }
    }
}
