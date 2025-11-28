package de.naci.ordermanagement;

public class Main {
    public static void main(String[] args) {
        Product p1 = new Product("Handy", 123, 1500.00, 50);
        Product p2 = new Product("Radio", 122, 250.00, 75);
        Product p3 = new Product("Stuhl", 120, 20.00, 200);
        Product p4 = new Product("Tisch", 121, 100.00, 150);

        Order o1 = new Order(111, Status.NEW);
        Order o2 = new Order(112, Status.NEW);
        Order o3 = new Order(113, Status.NEW);
        Order o4 = new Order(114, Status.NEW);

        o1.addProduct(p1);
        o2.addProduct(p2);
        o3.addProduct(p3);
        o4.addProduct(p4);

        OrderProcessor op1 = new OrderProcessor(o1);
        OrderProcessor op2 = new OrderProcessor(o2);
        OrderProcessor op3 = new OrderProcessor(o3);
        OrderProcessor op4 = new OrderProcessor(o4);

        op1.start();
        op2.start();
        op3.start();
        op4.start();

        try {
            op1.join();
            op2.join();
            op3.join();
            op4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Order " + o1.getOrderId() + ": " + o1.getStatus() + ", Gesamtpreis: " + o1.totalPrice());
        System.out.println("Order " + o2.getOrderId() + ": " + o2.getStatus() + ", Gesamtpreis: " + o2.totalPrice());
        System.out.println("Order " + o3.getOrderId() + ": " + o3.getStatus() + ", Gesamtpreis: " + o3.totalPrice());
        System.out.println("Order " + o4.getOrderId() + ": " + o4.getStatus() + ", Gesamtpreis: " + o4.totalPrice());

    }
}
