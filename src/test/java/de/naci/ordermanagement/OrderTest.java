package de.naci.ordermanagement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class OrderTest {
    @Test
    void testTotalPrice() {
        Product p1 = new Product("Handy", 123, 500.00, 5);
        Order o = new Order(123, Status.NEW);
        o.addProduct(p1);
        assertEquals(2500.00, o.totalPrice());
    }

    @Test
    void testSetStatus() {
        Order o = new Order(123, Status.NEW);
        o.setStatus(Status.PROCESSING);
        assertEquals(Status.PROCESSING, o.getStatus());
    }
}
