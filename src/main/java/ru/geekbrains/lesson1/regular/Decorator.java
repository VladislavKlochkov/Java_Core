package ru.geekbrains.lesson1.regular;

/**
 * Декоратор для декорации
 */
public class Decorator {
    public static String decorate(int number) {
        /**
         * Метод декорирует число, добавляя ему строку
         */
        return String.format("Result: %d.", number);
    }
}

