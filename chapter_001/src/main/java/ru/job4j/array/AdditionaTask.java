package ru.job4j.array;

public class AdditionaTask {

    public int[] unionTwoArray(int[] array1, int[] array2) {
        int[]  array3 = new int[array1.length + array2.length];
        int s = 0;
        int b = 0;
        for (int i = 0; i <= array1.length; i++) {
            for (int j = b; j < array2.length; j++) {
                if (i == array1.length) {
                    array3[s] = array2[j];
                    s++;
                }
                else if (array1[i] <= array2[j]) {
                    array3[s] = array1[i];
                    s++;
                    break;
                } else {
                    array3[s] = array2[j];
                    b++;
                    s++;
                    i--;
                    break;
                }
            }
        }
        return array3;
    }
}
