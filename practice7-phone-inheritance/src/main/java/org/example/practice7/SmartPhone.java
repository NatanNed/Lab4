package org.example.practice7;

import java.util.Objects;

/**
 * Похідний клас SmartPhone.
 * Описує смартфон із пам'яттю, камерою та підтримкою 5G.
 */
public class SmartPhone extends Phone {

    private int memoryGb;
    private int cameraMp;
    private boolean has5G;

    /**
     * Конструктор з параметрами.
     *
     * @param brand бренд
     * @param model модель
     * @param price ціна
     * @param batteryMah батарея
     * @param memoryGb пам'ять
     * @param cameraMp камера
     * @param has5G підтримка 5G
     */
    public SmartPhone(String brand,
                      String model,
                      double price,
                      int batteryMah,
                      int memoryGb,
                      int cameraMp,
                      boolean has5G) {

        super(brand, model, price, batteryMah);
        setMemoryGb(memoryGb);
        setCameraMp(cameraMp);
        setHas5G(has5G);
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
     * @return роздільна здатність камери
     */
    public int getCameraMp() {
        return cameraMp;
    }

    /**
     * @param cameraMp камера
     */
    public void setCameraMp(int cameraMp) {
        if (cameraMp <= 0) {
            throw new IllegalArgumentException("Camera MP must be positive");
        }

        this.cameraMp = cameraMp;
    }

    /**
     * @return true, якщо є підтримка 5G
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
     * @return тип телефону
     */
    @Override
    public String getPhoneType() {
        return "Смартфон";
    }

    /**
     * @return текстове представлення смартфона
     */
    @Override
    public String toString() {
        return super.toString().replace("}", "") +
                ", memoryGb=" + memoryGb +
                ", cameraMp=" + cameraMp +
                ", has5G=" + has5G +
                '}';
    }

    /**
     * @param obj інший об'єкт
     * @return true, якщо смартфони однакові
     */
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }

        SmartPhone that = (SmartPhone) obj;

        return memoryGb == that.memoryGb
                && cameraMp == that.cameraMp
                && has5G == that.has5G;
    }

    /**
     * @return hashCode об'єкта
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), memoryGb, cameraMp, has5G);
    }
}
