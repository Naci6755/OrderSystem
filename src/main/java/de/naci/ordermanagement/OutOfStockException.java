package de.naci.ordermanagement;

public class OutOfStockException extends Exception {
    public OutOfStockException(String message) {
        super(message);
    }

    public OutOfStockException() {
    };
}
