package org.example.practice6;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Драйвер-клас для Практичної роботи №6.
 * Демонструє enum, агрегацію, статичні члени та конструктор копіювання.
 */
public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final ArrayList<PhoneOwner> OWNERS = new ArrayList<>();

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
                case 1 -> createOwnerWithPhone();
                case 2 -> printAllOwners();
                case 3 -> copyFirstPhoneDemo();
                case 4 -> printStaticCounter();
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
     * Виводить інформаційну шапку програми.
     */
    private static void printHeader() {
        System.out.println("Практична робота №6");
        System.out.println("Класи, статичні члени, агрегація, enum");
        System.out.println("Предметна область: телефони");
    }

    /**
     * Виводить головне меню.
     */
    private static void printMenu() {
        System.out.println();
        System.out.println("===== МЕНЮ =====");
        System.out.println("1. Створити власника з телефоном");
        System.out.println("2. Вивести інформацію про всіх власників");
        System.out.println("3. Створити копію першого телефону");
        System.out.println("4. Показати кількість створених телефонів");
        System.out.println("5. Завершити роботу");
    }

    /**
     * Створює власника та телефон.
     */
    private static void createOwnerWithPhone() {
        try {
            String ownerName = readString("ПІБ власника: ");

            String brand = readString("Бренд телефону: ");
            String model = readString("Модель телефону: ");
            int memoryGb = readPositiveInt("Пам'ять, GB: ");
            double price = readPositiveDouble("Ціна: ");
            boolean has5G = readBoolean("Підтримує 5G? true/false: ");
            int batteryMah = readPositiveInt("Ємність батареї, mAh: ");
            double screenSize = readPositiveDouble("Розмір екрана: ");
            OperatingSystem operatingSystem = readOperatingSystem();

            Phone phone = new Phone(
                    brand,
                    model,
                    memoryGb,
                    price,
                    has5G,
                    batteryMah,
                    screenSize,
                    operatingSystem
            );

            PhoneOwner owner = new PhoneOwner(ownerName, phone);
            OWNERS.add(owner);

            System.out.println("Власника з телефоном успішно додано.");
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    /**
     * Виводить усіх власників.
     */
    private static void printAllOwners() {
        if (OWNERS.isEmpty()) {
            System.out.println("Список власників порожній.");
            return;
        }

        System.out.println("===== СПИСОК ВЛАСНИКІВ =====");

        for (int i = 0; i < OWNERS.size(); i++) {
            System.out.println((i + 1) + ". " + OWNERS.get(i));
        }
    }

    /**
     * Демонструє роботу конструктора копіювання.
     */
    private static void copyFirstPhoneDemo() {
        if (OWNERS.isEmpty()) {
            System.out.println("Немає телефонів для копіювання.");
            return;
        }

        Phone original = OWNERS.get(0).getPhone();
        Phone copy = new Phone(original);

        System.out.println("Оригінал:");
        System.out.println(original);

        System.out.println("Копія:");
        System.out.println(copy);
    }

    /**
     * Виводить кількість створених телефонів.
     */
    private static void printStaticCounter() {
        System.out.println("Кількість створених об'єктів Phone: "
                + Phone.getCreatedObjectsCount());
    }

    /**
     * Зчитує операційну систему.
     *
     * @return обране значення OperatingSystem
     */
    private static OperatingSystem readOperatingSystem() {
        while (true) {
            System.out.println("Оберіть операційну систему:");
            System.out.println("1. ANDROID");
            System.out.println("2. IOS");
            System.out.println("3. OTHER");

            int choice = readInt("Ваш вибір: ");

            switch (choice) {
                case 1:
                    return OperatingSystem.ANDROID;
                case 2:
                    return OperatingSystem.IOS;
                case 3:
                    return OperatingSystem.OTHER;
                default:
                    System.out.println("Помилка! Оберіть 1, 2 або 3.");
            }
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
