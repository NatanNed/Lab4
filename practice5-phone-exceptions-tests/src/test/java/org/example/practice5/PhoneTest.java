package org.example.practice5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тести для класу Phone.
 */
class PhoneTest {

    /**
     * Перевіряє виняток при некоректному значенні в сеттері.
     */
    @Test
    void shouldThrowExceptionWhenInvalidValueInSetter() {
        Phone phone = new Phone("Samsung", "Galaxy S23", 256, 30000.0, true, 5000, 6.7);

        assertThrows(IllegalArgumentException.class, () -> phone.setPrice(-1));
    }

    /**
     * Перевіряє виняток при створенні об'єкта з некоректними параметрами.
     */
    @Test
    void shouldThrowExceptionWhenInvalidConstructorData() {
        assertThrows(IllegalArgumentException.class, () ->
                new Phone("", "Galaxy S23", -256, 0.0, true, -5000, 0));
    }

    /**
     * Перевіряє створення об'єкта з коректними даними.
     */
    @Test
    void shouldCreatePhoneWhenDataIsValid() {
        Phone phone = new Phone("Apple", "iPhone 15", 128, 35000.0, true, 4000, 6.1);

        assertEquals("Apple", phone.getBrand());
        assertEquals("iPhone 15", phone.getModel());
        assertEquals(128, phone.getMemoryGb());
        assertEquals(35000.0, phone.getPrice());
        assertTrue(phone.isHas5G());
        assertEquals(4000, phone.getBatteryMah());
        assertEquals(6.1, phone.getScreenSize());
    }
}
