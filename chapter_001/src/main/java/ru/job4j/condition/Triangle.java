package ru.job4j.condition;
/**
 * @author Valeriy Vaskov (dar55@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Метод вычисления полупериметра по длинам сторон.
     * <p>
     * Формула.
     * <p>
     * (ab + ac + bc) / 2
     *
     * @param ab расстояние между точками a b
     * @param ac расстояние между точками a c
     * @param bc расстояние между точками b c
     * @return Перимент.
     */
    public double period(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2;
    }
    /**
     * Метод должен вычислить площадь треугольника.
     * @return Вернуть прощадь, если треугольник существует или -1, если треугольника нет.
     */
    public double area() {
        double rsl = -1;
        double ab = this.a.distanceTo(this.b);
        double ac = this.a.distanceTo(this.c);
        double bc = this.b.distanceTo(this.c);
        double p = this.period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            rsl = Math.sqrt(p * (p - ab) * (p - bc) * (p - ac));
        }
        return rsl;
    }

    /**
     * Метод проверяет можно ли построить треугольник с такими длинами сторон.
     *
     * Условие достаточности сущестования треугольника: сумма двух любых сторон больше третьей.
     *
     * @param ab Длина от точки a b.
     * @param ac Длина от точки a c.
     * @param bc Длина от точки b c.
     * @return существование треугольника
     */
    private boolean exist(double ab, double ac, double bc) {
        return (ab + ac > bc) & (ab + bc > ac) & (ac + bc > ab);
    }
}