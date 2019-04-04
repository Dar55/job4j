package ru.job4j;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        //    public static void main (String[] args) {
        //      String left = "amba";
        //      String right = "amba";
        int result = 0;
        int countable = 0;
        switch(Integer.compare(left.length(), right.length())) {
            case 0:
                     countable = left.length();
                     break;
            case -1:
                     countable = left.length();
                     result = -1;
                     break;
            case 1:
                     countable = right.length();
                     result = 1;
                     break;
        }

            for (int i = 0; i < countable; i++) {
                if (Character.compare(left.charAt(i), right.charAt(i)) != 0) {
                    result = Character.compare(left.charAt(i), right.charAt(i));
                    break;
                }
                ;
            }
      //  } else result = Integer.compare(left.length(), right.length());
    return result;
}
}
