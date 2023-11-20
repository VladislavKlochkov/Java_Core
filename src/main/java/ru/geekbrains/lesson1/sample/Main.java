package ru.geekbrains.lesson1.sample;

import ru.geekbrains.lesson1.regular.Calculator;
import ru.geekbrains.lesson1.regular.Decorator;

/**
 * Основной класс приложения.
 * Здесь мы можем описать его основное назначение и способы взаимодействия с ним.
 */
public class Main {
    /**
     * Точка входа в программу. С неё всегда всё начинается.
     *
     * @param args стандартные аргументы командной строки
     */
    public static void main(String[] args) {
        int result = Calculator.sum(5, 5);
        System.out.println(Decorator.decorate(result));
        result = Calculator.sub(8, 1);
        System.out.println(Decorator.decorate(result));
        result = Calculator.mul(7, 9);
        System.out.println(Decorator.decorate(result));
        result = Calculator.div(6, 2);
        System.out.println(Decorator.decorate(result));
    }
}
