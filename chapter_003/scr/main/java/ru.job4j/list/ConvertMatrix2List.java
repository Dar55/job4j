package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {

    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for ( int[] ar: array) {
            for (int ar1 : ar) {
                list.add(ar1);
            }
        }
        return list;
    }
    public List<Integer> convert (List<int[]> list){
        List<Integer> list1 = new ArrayList<>();
        for( int[] arr: list){
            for (int val : arr){
                list1.add(val);
            }
        }
        return list1;
    }
}
