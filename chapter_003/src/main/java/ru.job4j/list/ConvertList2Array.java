package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil(list.size() / (double) rows);
        int[][] array = new int[rows][cells];
        int i = 0;
        int j = 0;

        for (int li : list) {
            array[j][i] = li;
            if (i < cells - 1) {
             i++;
            } else {
                i = 0;
                j++;
            }
        }
        return array;
    }

}
