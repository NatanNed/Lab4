package org.example.practice6;

import java.util.Objects;

/**
 * Клас предметної області Phone.
 * Демонструє використання валідації, конструктора копіювання,
 * статичного поля та enum.
 */
public class Phone {

    private static int createdObjectsCount = 0;

    private String brand;
    private String model;
    private int memoryGb;
    private double price;
    private boolean has5G;
    private int batteryMah;
    private double screenSize;
    private OperatingSystem operatingSystem;

    /**
     * Конструктор з параметрами.
     *
     * @param brand бренд телефону
     * @param model модель телефону
     * @param memoryGb обсяг пам'яті
     * @param price ціна
     * @param has5G підтримка 5G
     * @param batteryMah ємність батареї
     * @param screenSize розмір екрана
     * @param operatingSystem операційна система
     */
    public Phone(String brand,
                 String model,
                 int memoryGb,
                 double price,
                 boolean has5G,
                 int batteryMah,
                 double screenSize,
                 OperatingSystem operatingSystem) {

        setBrand(brand);
        setModel(model);
        setMemoryGb(memoryGb);
        setPrice(price);
        setHas5G(has5G);
        setBatteryMah(batteryMah);
        setScreenSize(screenSize);
        setOperatingSystem(operatingSystem);

        createdObjectsCount++;
    }

    /**
     * Конструктор копіювання.
     *
     * @param other інший об'єкт Phone
     */
    public Phone(Phone other) {
        if (other == null) {
            throw new IllegalArgumentException("Phone for copying cannot be null");
        }

        this.brand = other.brand;
        this.model = other.model;
        this.memoryGb = other.memoryGb;
        this.price = other.price;
        this.has5G = other.has5G;
        this.batteryMah = other.batteryMah;
        this.screenSize = other.screenSize;
        this.operatingSystem = other.operatingSystem;

        createdObjectsCount++;
    }

    /**
     * Повертає кількість створених об'єктів Phone.
     *
     * @return кількість створених об'єктів
     */
    public static int getCreatedObjectsCount() {
        return createdObjectsCount;
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
     * @return true, якщо телефон підтримує 5G
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
     * @return операційна система
     */
    public OperatingSystem getOperatingSystem() {
        return operatingSystem;
    }

    /**
     * @param operatingSystem операційна система
     */
    public void setOperatingSystem(OperatingSystem operatingSystem) {
        if (operatingSystem == null) {
            throw new IllegalArgumentException("Operating system cannot be null");
        }

        this.operatingSystem = operatingSystem;
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
                ", operatingSystem=" + operatingSystem +
                '}';
    }

    /**
     * @param obj інший об'єкт
     * @return true, якщо телефони однакові
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

        return memoryGb == phone.memoryGb
                && Double.compare(phone.price, price) == 0
                && has5G == phone.has5G
                && batteryMah == phone.batteryMah
                && Double.compare(phone.screenSize, screenSize) == 0
                && Objects.equals(brand, phone.brand)
                && Objects.equals(model, phone.model)
                && operatingSystem == phone.operatingSystem;
    }

    /**
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(
                brand,
                model,
                memoryGb,
                price,
                has5G,
                batteryMah,
                screenSize,
                operatingSystem
        );
    }
}
