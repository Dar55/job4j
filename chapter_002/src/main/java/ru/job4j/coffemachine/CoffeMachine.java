package ru.job4j.coffemachine;

import java.util.*;


public class CoffeMachine {
    private final int[] nominal = {10, 5, 2, 1};
    private List moneyCount = new ArrayList<>();

    public List changes(int value, int price) {
        int change = value - price;

        for (int s : nominal) {
            if (change != 0) {
                for (int i = 1; i <= (change / s); i++) {
                    moneyCount.add(s);
                }
                change = change % s;
            }
        }
        return moneyCount;
    }
}
