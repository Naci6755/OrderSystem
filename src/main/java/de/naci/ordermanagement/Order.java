package de.naci.ordermanagement;

import java.util.*;

public class Order {
    // Attributen: orderId, product, quantity, status (NEW, PROCESSING,
    // COMPLETED,FAILED → enums!)
    private int orderID;
    private List<Product> products;
    private Map<Integer, Product> quantity;
    private Status status;

    public Order(int orderID, Status status) {
        this.orderID = orderID;
        this.products = new ArrayList<>();
        this.quantity = new HashMap<>();
        this.status = status;
    }

    public void addProduct(Product p){
        products.add(p);
    }

    // Methode zum Berechnen des Gesamtpreises
    public double totalPrice() {
        double count = 0.00;
        for (Product p : products) {
            count = p.getStockQuantity() * p.getPrice();
        }
        return count;
    }

}
