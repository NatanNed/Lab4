package org.example.practice7;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Драйвер-клас для Практичної роботи №7.
 * Демонструє наслідування, поліморфізм і роботу з ArrayList.
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
        printHeader();

        boolean running = true;

        while (running) {
            printMenu();
            int choice = readInt("Оберіть пункт меню: ");

            switch (choice) {
                case 1 -> createBasePhone();
                case 2 -> createSmartPhone();
                case 3 -> createKeypadPhone();
                case 4 -> printAllPhones();
                case 5 -> {
                    System.out.println("Роботу програми завершено.");
                    running = false;
                }
                default -> System.out.println("Помилка! Такого пункту меню немає.");
            }
        }

        SCANNER.close();
    }

    /**
     * Виводить інформаційну шапку.
     */
    private static void printHeader() {
        System.out.println("Практична робота №7");
        System.out.println("Наслідування, поліморфізм, ArrayList");
        System.out.println("Варіант 3: Phone, SmartPhone, KeypadPhone");
    }

    /**
     * Виводить меню програми.
     */
    private static void printMenu() {
        System.out.println();
        System.out.println("===== МЕНЮ =====");
        System.out.println("1. Створити Phone");
        System.out.println("2. Створити SmartPhone");
        System.out.println("3. Створити KeypadPhone");
        System.out.println("4. Вивести інформацію про всі телефони");
        System.out.println("5. Завершити роботу");
    }

    /**
     * Створює базовий телефон.
     */
    private static void createBasePhone() {
        try {
            String brand = readString("Бренд: ");
            String model = readString("Модель: ");
            double price = readPositiveDouble("Ціна: ");
            int batteryMah = readPositiveInt("Батарея, mAh: ");

            Phone phone = new Phone(brand, model, price, batteryMah);
            PHONES.add(phone);

            System.out.println("Phone додано до колекції.");
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    /**
     * Створює смартфон.
     */
    private static void createSmartPhone() {
        try {
            String brand = readString("Бренд: ");
            String model = readString("Модель: ");
            double price = readPositiveDouble("Ціна: ");
            int batteryMah = readPositiveInt("Батарея, mAh: ");
            int memoryGb = readPositiveInt("Пам'ять, GB: ");
            int cameraMp = readPositiveInt("Камера, MP: ");
            boolean has5G = readBoolean("Підтримує 5G? true/false: ");

            SmartPhone phone = new SmartPhone(
                    brand,
                    model,
                    price,
                    batteryMah,
                    memoryGb,
                    cameraMp,
                    has5G
            );

            PHONES.add(phone);

            System.out.println("SmartPhone додано до колекції.");
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    /**
     * Створює кнопковий телефон.
     */
    private static void createKeypadPhone() {
        try {
            String brand = readString("Бренд: ");
            String model = readString("Модель: ");
            double price = readPositiveDouble("Ціна: ");
            int batteryMah = readPositiveInt("Батарея, mAh: ");
            boolean hasFlashlight = readBoolean("Є ліхтарик? true/false: ");
            boolean hasFmRadio = readBoolean("Є FM-радіо? true/false: ");

            KeypadPhone phone = new KeypadPhone(
                    brand,
                    model,
                    price,
                    batteryMah,
                    hasFlashlight,
                    hasFmRadio
            );

            PHONES.add(phone);

            System.out.println("KeypadPhone додано до колекції.");
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    /**
     * Виводить усі телефони з єдиної колекції.
     */
    private static void printAllPhones() {
        if (PHONES.isEmpty()) {
            System.out.println("Колекція телефонів порожня.");
            return;
        }

        System.out.println();
        System.out.println("===== УСІ ТЕЛЕФОНИ =====");

        for (int i = 0; i < PHONES.size(); i++) {
            Phone phone = PHONES.get(i);
            System.out.println((i + 1) + ". " + phone);
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
     * @return ціле число
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
     * @return додатне ціле число
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
     * @return додатне дробове число
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
     * Зчитує логічне значення.
     *
     * @param message повідомлення
     * @return true або false
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
