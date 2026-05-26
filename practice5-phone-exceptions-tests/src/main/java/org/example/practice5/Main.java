package org.example.practice5;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Драйвер-клас для Практичної роботи №5.
 * Містить консольне меню для створення та перегляду об'єктів Phone.
 */
public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final ArrayList<Phone> PHONES = new ArrayList<>();

    /**
     * Точка входу в програму.
     *
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            printMenu();
            int choice = readInt("Оберіть пункт меню: ");

            switch (choice) {
                case 1 -> createPhone();
                case 2 -> printPhones();
                case 3 -> {
                    System.out.println("Роботу програми завершено.");
                    running = false;
                }
                default -> System.out.println("Помилка! Такого пункту меню немає.");
            }
        }

        SCANNER.close();
    }

    /**
     * Виводить меню програми.
     */
    private static void printMenu() {
        System.out.println();
        System.out.println("===== МЕНЮ =====");
        System.out.println("1. Створити новий об'єкт");
        System.out.println("2. Вивести інформацію про всі об'єкти");
        System.out.println("3. Завершити роботу");
    }

    /**
     * Створює новий телефон.
     */
    private static void createPhone() {
        try {
            String brand = readString("Бренд: ");
            String model = readString("Модель: ");
            int memoryGb = readPositiveInt("Пам'ять, GB: ");
            double price = readPositiveDouble("Ціна: ");
            boolean has5G = readBoolean("Підтримує 5G? true/false: ");
            int batteryMah = readPositiveInt("Ємність батареї, mAh: ");
            double screenSize = readPositiveDouble("Розмір екрана: ");

            Phone phone = new Phone(brand, model, memoryGb, price, has5G, batteryMah, screenSize);
            PHONES.add(phone);

            System.out.println("Телефон успішно додано.");
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка створення об'єкта: " + e.getMessage());
        }
    }

    /**
     * Виводить усі телефони.
     */
    private static void printPhones() {
        if (PHONES.isEmpty()) {
            System.out.println("Список телефонів порожній.");
            return;
        }

        System.out.println("===== СПИСОК ТЕЛЕФОНІВ =====");

        for (int i = 0; i < PHONES.size(); i++) {
            System.out.println((i + 1) + ". " + PHONES.get(i));
        }
    }

    /**
     * Зчитує непорожній рядок.
     *
     * @param message повідомлення
     * @return рядок
     */
    private static String readString(String message) {
        while (true) {
            System.out.print(message);
            String value = SCANNER.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println("Помилка! Рядок не може бути порожнім.");
        }
    }

    /**
     * Зчитує ціле число.
     *
     * @param message повідомлення
     * @return число
     */
    private static int readInt(String message) {
        while (true) {
            System.out.print(message);

            if (SCANNER.hasNextInt()) {
                int value = SCANNER.nextInt();
                SCANNER.nextLine();
                return value;
            }

            SCANNER.nextLine();
            System.out.println("Помилка! Введіть ціле число.");
        }
    }

    /**
     * Зчитує додатне ціле число.
     *
     * @param message повідомлення
     * @return додатне число
     */
    private static int readPositiveInt(String message) {
        while (true) {
            int value = readInt(message);

            if (value > 0) {
                return value;
            }

            System.out.println("Помилка! Число має бути додатним.");
        }
    }

    /**
     * Зчитує додатне дробове число.
     *
     * @param message повідомлення
     * @return додатне число
     */
    private static double readPositiveDouble(String message) {
        while (true) {
            System.out.print(message);

            if (SCANNER.hasNextDouble()) {
                double value = SCANNER.nextDouble();
                SCANNER.nextLine();

                if (value > 0) {
                    return value;
                }
            } else {
                SCANNER.nextLine();
            }

            System.out.println("Помилка! Введіть додатне число.");
        }
    }

    /**
     * Зчитує true або false.
     *
     * @param message повідомлення
     * @return логічне значення
     */
    private static boolean readBoolean(String message) {
        while (true) {
            System.out.print(message);
            String value = SCANNER.nextLine().trim().toLowerCase();

            if (value.equals("true") || value.equals("так") || value.equals("yes")) {
                return true;
            }

            if (value.equals("false") || value.equals("ні") || value.equals("no")) {
                return false;
            }

            System.out.println("Помилка! Введіть true або false.");
        }
    }
}
