package org.example.practice5;

import java.util.Objects;

/**
 * Клас предметної області Phone.
 * Описує телефон і містить перевірку коректності вхідних даних.
 */
public class Phone {

    private String brand;
    private String model;
    private int memoryGb;
    private double price;
    private boolean has5G;
    private int batteryMah;
    private double screenSize;

    /**
     * Конструктор з параметрами.
     *
     * @param brand бренд телефону
     * @param model модель телефону
     * @param memoryGb обсяг пам'яті у GB
     * @param price ціна телефону
     * @param has5G підтримка 5G
     * @param batteryMah ємність батареї
     * @param screenSize розмір екрана
     */
    public Phone(String brand, String model, int memoryGb, double price,
                 boolean has5G, int batteryMah, double screenSize) {
        setBrand(brand);
        setModel(model);
        setMemoryGb(memoryGb);
        setPrice(price);
        setHas5G(has5G);
        setBatteryMah(batteryMah);
        setScreenSize(screenSize);
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
     * @return обсяг пам'яті
     */
    public int getMemoryGb() {
        return memoryGb;
    }

    /**
     * @param memoryGb обсяг пам'яті
     */
    public void setMemoryGb(int memoryGb) {
        if (memoryGb <= 0) {
            throw new IllegalArgumentException("Memory must be positive");
        }
        this.memoryGb = memoryGb;
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
     * @return true, якщо є 5G
     */
    public boolean isHas5G() {
        return has5G;
    }

    /**
     * @param has5G підтримка 5G
     */
    public void setHas5G(boolean has5G) {
        this.has5G = has5G;
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
     * @return розмір екрана
     */
    public double getScreenSize() {
        return screenSize;
    }

    /**
     * @param screenSize розмір екрана
     */
    public void setScreenSize(double screenSize) {
        if (screenSize <= 0) {
            throw new IllegalArgumentException("Screen size must be positive");
        }
        this.screenSize = screenSize;
    }

    /**
     * @return текстове представлення телефону
     */
    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", memoryGb=" + memoryGb +
                ", price=" + price +
                ", has5G=" + has5G +
                ", batteryMah=" + batteryMah +
                ", screenSize=" + screenSize +
                '}';
    }

    /**
     * @param obj інший об'єкт
     * @return true, якщо об'єкти однакові
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Phone phone = (Phone) obj;

        return memoryGb == phone.memoryGb
                && Double.compare(phone.price, price) == 0
                && has5G == phone.has5G
                && batteryMah == phone.batteryMah
                && Double.compare(phone.screenSize, screenSize) == 0
                && Objects.equals(brand, phone.brand)
                && Objects.equals(model, phone.model);
    }

    /**
     * @return hashCode об'єкта
     */
    @Override
    public int hashCode() {
        return Objects.hash(brand, model, memoryGb, price, has5G, batteryMah, screenSize);
    }
}
