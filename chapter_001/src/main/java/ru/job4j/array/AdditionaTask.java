package ru.job4j.array;

public class AdditionaTask {

    public int[] unionTwoArray(int[] array1, int[] array2) {
        int[]  array3 = new int[array1.length + array2.length];
        int s = 0;
        int b;
        int j = 0;
        int i = 0;
            while (i < array1.length && j < array2.length) {
                if (array1[i] <= array2[j]) {
                    array3[s++] = array1[i++];
                } else {
                    array3[s++] = array2[j++];
                }
            }
        if (i < array1.length) {
            for (b = i; b < array1.length; b++) {
                array3[s++] = array1[b];
            }
        } else if (j < array2.length) {
                for (b = j; b < array2.length; b++) {
                    array3[s++] = array2[b];
                }
        }

        return array3;
    }
}
