package ru.job4j;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class Calculator {

    public interface Operation {
        double calc(int left, int right);
    }
    @FunctionalInterface
    public interface Function {
        double calc(int start, int finish);
    }

    public void multiple(int start, int finish, int value,
                         BiFunction<Integer, Integer, Double> op,
                         Consumer<Double> media) {
        for (int index = start; index != finish; index++) {
            media.accept(op.apply(value, index));
        }
    }

    public List<Double> diapason (int start, int finish, UnaryOperator<Double> linear) {
        List<Double> list = new ArrayList<>();
        for (int index = start; index != finish; index++) {
           Double inr = (double) index;
           list.add(linear.apply(inr));
        }
        return list;
    }


  //  public static void main(String[] args) {
    //    Calculator calc = new Calculator();
   //          calc.multiple(0, 10, 2,MathUtil::add,
   //            result -> System.out.println(result));
//
   // }
}