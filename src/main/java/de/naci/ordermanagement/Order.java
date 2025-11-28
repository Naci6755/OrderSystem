package de.naci.ordermanagement;
import java.util.*;

public class Order {
    //Attributen: orderId, product, quantity, status (NEW, PROCESSING, COMPLETED,FAILED → enums!)
    private int orderID;
    private List<Product> products;
    private Product quantity;
    private Status status;

    public Order(int orderID, Product quantity, Status status){
        this.orderID=orderID;
        this.products=new ArrayList<>();
        this.quantity=quantity;
        this.status=status;
    }

    //Methode zum Berechnen des Gesamtpreises
    public int totalPrice(int amount){
        throw new Error("bald..");
    }

}
