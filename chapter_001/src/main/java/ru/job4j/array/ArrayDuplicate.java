package ru.job4j.array;
import java.util.Arrays;
public class ArrayDuplicate {
    public String[] remove(String[] array) {
        int z = 0;
        boolean m;
        for (int i = 1; i < array.length; i++) {
            m = true;
            for (int j = i - 1; j >= 0; j--) {
                if (array[i].equals(array[j])) {
                    m = false;
                    break;
                }
            }
            if (m) {
                z++;
                array[z] = array[i];
            }
        }
        return Arrays.copyOf(array, z + 1);
    }
}
