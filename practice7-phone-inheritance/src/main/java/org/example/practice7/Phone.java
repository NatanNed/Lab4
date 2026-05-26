package org.example.practice7;

import java.util.Objects;

/**
 * Базовий клас Phone.
 * Описує загальні характеристики телефону.
 */
public class Phone {

    private String brand;
    private String model;
    private double price;
    private int batteryMah;

    /**
     * Конструктор з параметрами.
     *
     * @param brand бренд телефону
     * @param model модель телефону
     * @param price ціна телефону
     * @param batteryMah ємність батареї
     */
    public Phone(String brand, String model, double price, int batteryMah) {
        setBrand(brand);
        setModel(model);
        setPrice(price);
        setBatteryMah(batteryMah);
    }

    /**
     * @return бренд телефону
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand бренд телефону
     */
    public void setBrand(String brand) {
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException("Brand cannot be empty");
        }

        this.brand = brand.trim();
    }

    /**
     * @return модель телефону
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model модель телефону
     */
    public void setModel(String model) {
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Model cannot be empty");
        }

        this.model = model.trim();
    }

    /**
     * @return ціна телефону
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price ціна телефону
     */
    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be positive");
        }

        this.price = price;
    }

    /**
     * @return ємність батареї
     */
    public int getBatteryMah() {
        return batteryMah;
    }

    /**
     * @param batteryMah ємність батареї
     */
    public void setBatteryMah(int batteryMah) {
        if (batteryMah <= 0) {
            throw new IllegalArgumentException("Battery capacity must be positive");
        }

        this.batteryMah = batteryMah;
    }

    /**
     * Повертає тип телефону.
     *
     * @return тип телефону
     */
    public String getPhoneType() {
        return "Звичайний телефон";
    }

    /**
     * @return текстове представлення об'єкта
     */
    @Override
    public String toString() {
        return getPhoneType() +
                " {brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", batteryMah=" + batteryMah +
                '}';
    }

    /**
     * @param obj інший об'єкт
     * @return true, якщо об'єкти однакові
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Phone phone = (Phone) obj;

        return Double.compare(phone.price, price) == 0
                && batteryMah == phone.batteryMah
                && Objects.equals(brand, phone.brand)
                && Objects.equals(model, phone.model);
    }

    /**
     * @return hashCode об'єкта
     */
    @Override
    public int hashCode() {
        return Objects.hash(brand, model, price, batteryMah);
    }
}
