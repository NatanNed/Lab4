package org.example.practice7;

import java.util.Objects;

/**
 * Похідний клас KeypadPhone.
 * Описує кнопковий телефон.
 */
public class KeypadPhone extends Phone {

    private boolean hasFlashlight;
    private boolean hasFmRadio;

    /**
     * Конструктор з параметрами.
     *
     * @param brand бренд
     * @param model модель
     * @param price ціна
     * @param batteryMah батарея
     * @param hasFlashlight наявність ліхтарика
     * @param hasFmRadio наявність FM-радіо
     */
    public KeypadPhone(String brand,
                       String model,
                       double price,
                       int batteryMah,
                       boolean hasFlashlight,
                       boolean hasFmRadio) {

        super(brand, model, price, batteryMah);
        setHasFlashlight(hasFlashlight);
        setHasFmRadio(hasFmRadio);
    }

    /**
     * @return true, якщо є ліхтарик
     */
    public boolean isHasFlashlight() {
        return hasFlashlight;
    }

    /**
     * @param hasFlashlight наявність ліхтарика
     */
    public void setHasFlashlight(boolean hasFlashlight) {
        this.hasFlashlight = hasFlashlight;
    }

    /**
     * @return true, якщо є FM-радіо
     */
    public boolean isHasFmRadio() {
        return hasFmRadio;
    }

    /**
     * @param hasFmRadio наявність FM-радіо
     */
    public void setHasFmRadio(boolean hasFmRadio) {
        this.hasFmRadio = hasFmRadio;
    }

    /**
     * @return тип телефону
     */
    @Override
    public String getPhoneType() {
        return "Кнопковий телефон";
    }

    /**
     * @return текстове представлення кнопкового телефону
     */
    @Override
    public String toString() {
        return super.toString().replace("}", "") +
                ", hasFlashlight=" + hasFlashlight +
                ", hasFmRadio=" + hasFmRadio +
                '}';
    }

    /**
     * @param obj інший об'єкт
     * @return true, якщо об'єкти однакові
     */
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }

        KeypadPhone that = (KeypadPhone) obj;

        return hasFlashlight == that.hasFlashlight
                && hasFmRadio == that.hasFmRadio;
    }

    /**
     * @return hashCode об'єкта
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hasFlashlight, hasFmRadio);
    }
}
