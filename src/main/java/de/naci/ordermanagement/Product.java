package de.naci.ordermanagement;
public class Product {
    //Attributen: id, name, price, stockQuantity
    private int id;
    private String name;
    private double price;
    private int stockQuantity;

    public Product(String name, int id, double price, int stockQuantity){
        this.name=name;
        this.id=id;
        this.price=price;
        this.stockQuantity=stockQuantity;
    }

    //Methode reduceStock(int amount) die eine OutOfStockException wirft, wenn nicht genug Lagerbestand
    public void reduceStock(int amount) throws OutOfStockException{
        if(amount>this.stockQuantity){
            throw new OutOfStockException("Nicht genug auf Lager.");
        }
        this.stockQuantity-=amount;
    }
}
