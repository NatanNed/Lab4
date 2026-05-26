package org.example.practice4;

import java.util.Objects;

/**
 * Клас предметної області Phone.
 * Описує мобільний телефон з основними характеристиками.
 */
public class Phone {

    private String brand;
    private String model;
    private int memoryGb;
    private double price;
    private boolean has5G;

    /**
     * Конструктор з параметрами.
     *
     * @param brand бренд телефону
     * @param model модель телефону
     * @param memoryGb обсяг пам'яті у GB
     * @param price ціна телефону
     * @param has5G наявність підтримки 5G
     */
    public Phone(String brand, String model, int memoryGb, double price, boolean has5G) {
        this.brand = brand;
        this.model = model;
        this.memoryGb = memoryGb;
        this.price = price;
        this.has5G = has5G;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMemoryGb() {
        return memoryGb;
    }

    public void setMemoryGb(int memoryGb) {
        this.memoryGb = memoryGb;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isHas5G() {
        return has5G;
    }

    public void setHas5G(boolean has5G) {
        this.has5G = has5G;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", memoryGb=" + memoryGb +
                ", price=" + price +
                ", has5G=" + has5G +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Phone phone = (Phone) obj;

        return memoryGb == phone.memoryGb
                && Double.compare(phone.price, price) == 0
                && has5G == phone.has5G
                && Objects.equals(brand, phone.brand)
                && Objects.equals(model, phone.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, memoryGb, price, has5G);
    }
}
