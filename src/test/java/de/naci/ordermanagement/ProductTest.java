package de.naci.ordermanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class ProductTest {
    
    @Test
    @Order(1)
    void testReduceStock() throws OutOfStockException{
        Product p1 = new Product("Handy", 123, 500.00, 50);
        p1.reduceStock(20);
        assertEquals(p1.getStockQuantity(), 30);
    }
}
