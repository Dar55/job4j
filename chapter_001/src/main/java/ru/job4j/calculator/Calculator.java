package ru.job4j.calculator;
/**
 * @author Valeriy Vaskov (dar55@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Calculator {
    /**
     * Отвечает на вопросы.
     * @param first  Первое значение суммы.
     * @param second  Второе значение суммы.
     * @return Сумму двух значений
     */
    private double result;

    public void add(double first, double second) {
        this.result = first + second;
    }
    /**
     * Отвечает на вопросы.
     * @param first  Первое значение разницы.
     * @param second  Второе значение разницы.
     * @return Разница двух значений
     */
    public void sub(double first, double second) {
        this.result = first - second;
    }
    /**
     * Отвечает на вопросы.
     * @param first  Первое значение произведения.
     * @param second  Второе значение произведения.
     * @return произведение двух значений
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }
    /**
     * Отвечает на вопросы.
     * @param first  Делимое
     * @param second  Делитель
     * @return Результат деления
     */
    public void div(double first, double second) {
        this.result = first / second;
    }
    public double getResult() {
        return this.result;
    }

}
