package de.naci.ordermanagement;

public class OrderProcessingException extends Exception{
    public OrderProcessingException(String message){
        super(message);
    }

    public OrderProcessingException(){};
}
