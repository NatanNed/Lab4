package org.example.practice6;

/**
 * Клас PhoneOwner демонструє агрегацію.
 * Власник телефону містить посилання на об'єкт Phone.
 */
public class PhoneOwner {

    private String fullName;
    private Phone phone;

    /**
     * Конструктор з параметрами.
     *
     * @param fullName ПІБ власника
     * @param phone телефон власника
     */
    public PhoneOwner(String fullName, Phone phone) {
        setFullName(fullName);
        setPhone(phone);
    }

    /**
     * @return ПІБ власника
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName ПІБ власника
     */
    public void setFullName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("Owner name cannot be empty");
        }

        this.fullName = fullName.trim();
    }

    /**
     * @return телефон власника
     */
    public Phone getPhone() {
        return phone;
    }

    /**
     * @param phone телефон власника
     */
    public void setPhone(Phone phone) {
        if (phone == null) {
            throw new IllegalArgumentException("Phone cannot be null");
        }

        this.phone = phone;
    }

    /**
     * @return текстове представлення власника телефону
     */
    @Override
    public String toString() {
        return "PhoneOwner{" +
                "fullName='" + fullName + '\'' +
                ", phone=" + phone +
                '}';
    }
}
