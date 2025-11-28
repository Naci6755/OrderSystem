package de.naci.ordermanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class ProductTest {
    
    @Test
    @Order(1)  //normalfall
    void testReduceStock() throws OutOfStockException{
        Product p1 = new Product("Handy", 123, 500.00, 50);
        p1.reduceStock(20);
        assertEquals(p1.getStockQuantity(), 30);
    }
    @Test
    @Order(2)
     void testReduceStockErr() throws OutOfStockException{
        Product p1 = new Product("Handy", 123, 500.00, 50);
        assertThrows(OutOfStockException.class, ()->{p1.reduceStock(70);});
    }
}
