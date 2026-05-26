package org.example.practice4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * ЛР №4.
 * Варіант 3: клас Phone + ArrayList з 5 об'єктів.
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Phone> phones = new ArrayList<>();

        System.out.println("Практична робота №4");
        System.out.println("Варіант 3: клас Phone + ArrayList з 5 об'єктів");
        System.out.println();

        phones.add(new Phone("Apple", "iPhone 14", 128, 29999.99, true));
        phones.add(new Phone("Samsung", "Galaxy S23", 256, 27999.50, true));
        phones.add(new Phone("Xiaomi", "Redmi Note 13", 128, 8999.00, false));

        System.out.println("Введіть дані ще для 2 телефонів.");

        for (int i = 4; i <= 5; i++) {
            System.out.println();
            System.out.println("Телефон №" + i);

            System.out.print("Бренд: ");
            String brand = readNonEmptyLine(scanner);

            System.out.print("Модель: ");
            String model = readNonEmptyLine(scanner);

            int memoryGb = readPositiveInt(scanner, "Пам'ять, GB: ");
            double price = readPositiveDouble(scanner, "Ціна: ");

            System.out.print("Підтримує 5G? true/false: ");
            boolean has5G = readBoolean(scanner);

            phones.add(new Phone(brand, model, memoryGb, price, has5G));
        }

        System.out.println();
        System.out.println("Список усіх телефонів:");

        for (Phone phone : phones) {
            System.out.println(phone);
        }

        System.out.println();
        System.out.println("Перевірка equals():");
        System.out.println("Перший і другий телефони однакові? " + phones.get(0).equals(phones.get(1)));

        scanner.close();
    }

    private static String readNonEmptyLine(Scanner scanner) {
        String value;

        while (true) {
            value = scanner.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.print("Значення не може бути порожнім. Введіть ще раз: ");
        }
    }

    private static int readPositiveInt(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);

            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine();

                if (value > 0) {
                    return value;
                }
            } else {
                scanner.nextLine();
            }

            System.out.println("Помилка! Введіть додатне ціле число.");
        }
    }

    private static double readPositiveDouble(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);

            if (scanner.hasNextDouble()) {
                double value = scanner.nextDouble();
                scanner.nextLine();

                if (value > 0) {
                    return value;
                }
            } else {
                scanner.nextLine();
            }

            System.out.println("Помилка! Введіть додатне число.");
        }
    }

    private static boolean readBoolean(Scanner scanner) {
        while (true) {
            String value = scanner.nextLine().trim().toLowerCase();

            if (value.equals("true") || value.equals("так") || value.equals("yes")) {
                return true;
            }

            if (value.equals("false") || value.equals("ні") || value.equals("no")) {
                return false;
            }

            System.out.print("Помилка! Введіть true або false: ");
        }
    }
}
