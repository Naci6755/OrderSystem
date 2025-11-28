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

    @Test
    void testParallele() {
        Product p1 = new Product("Handy", 123, 1500.00, 50);
        Product p2 = new Product("Radio", 122, 250.00, 75);

        Order o1 = new Order(111, Status.NEW);
        Order o2 = new Order(112, Status.NEW);

        o1.addProduct(p1);
        o2.addProduct(p2);
        OrderProcessor op1 = new OrderProcessor(o1);
        OrderProcessor op2 = new OrderProcessor(o2);
        op1.start();
        op2.start();

        try {
            op1.join();
            op2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals(Status.COMPLETED, o1.getStatus());
        assertEquals(Status.COMPLETED, o2.getStatus());

    }

    @Test
    void testLagerVoll() {
        Product p = new Product("Handy", 123, 1500.00, 10);

        Order o = new Order(111, Status.NEW);

        o.addProduct(p);

        o.getQuantity().put(p, 50);
        OrderProcessor op = new OrderProcessor(o);
        op.start();

        try {
            op.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals(Status.FAILED, o.getStatus());

    }
}
