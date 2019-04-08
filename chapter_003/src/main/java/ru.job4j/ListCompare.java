package ru.job4j;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {

        int result = 0;
        int countable =  left.length() - right.length() > 0 ? right.length() : left.length();
        for (int i = 0; i < countable; i++) {
                result = Character.compare(left.charAt(i), right.charAt(i));
                if (result != 0) {
                    break;
                }

        }
        if ((Integer.compare(left.length(), right.length()) !=0) && (result == 0)) {
                result = Integer.compare(left.length(), right.length());
        }
    return result;
}
}
