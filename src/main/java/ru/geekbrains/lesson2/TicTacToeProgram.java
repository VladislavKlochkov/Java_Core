package ru.geekbrains.lesson2;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeProgram {
    private static final char DOT_HUMAN = 'X';  // Фишка игрока - человек.
    private static final char DOT_AI = '0';     // Фишка игрока - компьютер.
    private static final char DOT_EMPTY = '*';  // Обозначение пустого поля.
    private static final int WIN_COUNT = 4;     // Условие победы.

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    private static char[][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;

    /**
     * Бесконечный цикл игры
     */
    public static void main(String[] args) {
        while (true) {
            initialize();
            printField();
            while (true) {
                humanTurn();
                printField();
                if (checkGameState(DOT_HUMAN, "Вы победили!"))
                    break;
                aiTurn();
                printField();
                if (checkGameState(DOT_AI, "Победил компьютер!"))
                    break;
            }
            System.out.print("Желаете сыграть еще раз? (Y - да): ");
            if (!scanner.next().equalsIgnoreCase("Y"))
                break;
        }
    }

    /**
     * Инициализация игрового поля
     */
    static void initialize() {
        do {
            System.out.println("Введите размер игрового поля: ");
            System.out.print("Введите количество полей по оси X: ");
            fieldSizeX = scanner.nextInt();
            System.out.print("Введите количество полей по оси Y: ");
            fieldSizeY = scanner.nextInt();
        }
        while (fieldSizeX < 0 || fieldSizeY < 0);

        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    /**
     * Печать текущего состояния игрового поля
     */
    private static void printField() {
        System.out.print("+");
        for (int i = 0; i < fieldSizeX; i++) {
            System.out.print("-" + (i + 1));
        }
        System.out.println("-");

        for (int y = 0; y < fieldSizeY; y++) {
            System.out.print(y + 1 + "|");
            for (int x = 0; x < fieldSizeX; x++) {
                System.out.print(field[y][x] + "|");
            }
            System.out.println();
        }

        for (int i = 0; i < fieldSizeX * 2 + 2; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * Ход игрока (человека)
     */
    static void humanTurn() {
        int x;
        int y;

        do {
            System.out.printf("Введите координаты хода по оси X (от 1 до " + fieldSizeX + ")"
                    + " и по оси Y (от 1 до " + fieldSizeY + ")" + " через пробел: ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        }
        while (!isCellValid(x, y) || !isCellEmpty(x, y));

        field[y][x] = DOT_HUMAN;
    }

    /**
     * Ход игрока (компьютера)
     */
    static void aiTurn() {
        int x;
        int y;

        do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        }
        while (!isCellEmpty(x, y));

        field[y][x] = DOT_AI;
    }

    /**
     * Проверка, является ли ячейка игрового поля пустой
     *
     * @param x
     * @param y
     * @return
     */
    static boolean isCellEmpty(int x, int y) {
        return field[y][x] == DOT_EMPTY;
    }

    /**
     * Проверка доступности ячейки игрового поля
     *
     * @param x
     * @param y
     * @return
     */
    static boolean isCellValid(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }


    /**
     * Метод проверки состояния игры
     *
     * @param dot - фишка игрока
     * @param s   - победный слоган
     * @return - результат проверки состояния игры
     */
    static boolean checkGameState(char dot, String s) {
        if (checkWin(dot)) {
            System.out.println(s);
            return true;
        }
        if (checkDraw()) {
            System.out.println("Ничья!");
            return true;
        }
        return false; // Игра продолжается
    }

    /**
     * Проверка на ничью
     *
     * @return
     */
    static boolean checkDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isCellEmpty(x, y))
                    return false;
            }
        }
        return true;
    }

    /**
     * Проверка победы игрока
     *
     * @param dot - фишка игрока
     * @return - признак победы
     */
    static boolean checkWin(char dot) {
        // Проверка по горизонтали
        if (checkHorizontalWin(dot, WIN_COUNT)) return true;
        // Проверка по вертикали
        if (checkVerticalWin(dot, WIN_COUNT)) return true;
        // Проверка по диагоналям
        if (checkDownwardDiagonalWin(dot, WIN_COUNT)) return true;
        return (checkAscendingDiagonalWin(dot, WIN_COUNT));
    }

    /**
     * Метод проверки выигрыша по горизонтали
     *
     * @param dot       - фишка игрока
     * @param WIN_COUNT - выигрышная комбинация
     * @return
     */
    static boolean checkHorizontalWin(char dot, int WIN_COUNT) {
        boolean result = false;
        int count = 0;
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY && y < fieldSizeX; y++) {
                if (field[x][y] == dot) {
                    count++;
                }
                if (count == WIN_COUNT) {
                    result = true;
                }
            }
            count = 0;
        }
        return result;
    }

    /**
     * Метод проверки выигрыша по вертикали
     *
     * @param dot       - фишка игрока
     * @param WIN_COUNT - выигрышная комбинация
     * @return
     */
    static boolean checkVerticalWin(char dot, int WIN_COUNT) {
        boolean result = false;
        int count = 0;
        for (int x = 0; x < fieldSizeX && x < fieldSizeY; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                if (field[y][x] == dot) {
                    count++;
                }
                if (count == WIN_COUNT) {
                    result = true;
                }
            }
            count = 0;
        }
        return result;
    }

    /**
     * Метод проверки выигрыша по нисходящей диагонали
     *
     * @param dot       - фишка игрока
     * @param WIN_COUNT - выигрышная комбинация
     * @return
     */
    static boolean checkDownwardDiagonalWin(char dot, int WIN_COUNT) {
        boolean result = false;
        int count = 0;
        for (int x = 0; x < fieldSizeX; x++) {
            if (field[x][x] == dot) {
                count++;
            }
        }
        if (count == WIN_COUNT) {
            result = true;
        }
        return result;
    }

    /**
     * Метод проверки выигрыша по восходящей диагонали
     *
     * @param dot       - фишка игрока
     * @param WIN_COUNT - выигрышная комбинация
     * @return
     */
    static boolean checkAscendingDiagonalWin(char dot, int WIN_COUNT) {
        boolean result = false;
        int count = 0;
        for (int x = 0; x < fieldSizeX; x++) {
            if (field[fieldSizeX - x - 1][x] == dot) {
                count++;
            }
        }
        if (count == WIN_COUNT) {
            result = true;
        }
        return result;
    }
}
