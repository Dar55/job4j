package ru.job4j.array;

public class FindLoop {
    public int indexOf(int[] data, int el) {
        int rst = -1;
        int i=0;
        for (int index:data) {
            //System.out.println(index);
            if (index == el) {
                rst = i;
                break;
            }
            i++;
        }
        return rst;
    }
}
