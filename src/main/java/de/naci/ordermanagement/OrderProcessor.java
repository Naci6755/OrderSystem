package de.naci.ordermanagement;

import java.util.Map;

public class OrderProcessor extends Thread {
    private Order order;

    public OrderProcessor(Order order) {
        this.order = order;
    }

    public void run() {
        this.order.setStatus(Status.PROCESSING);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean fehler = false;
        for (Product p : this.order.getProducts()) {
            int menge = this.order.getQuantity().get(p);
            
            try {
                p.reduceStock(menge);
            } catch (OutOfStockException e) {
                fehler = true;
                this.order.setStatus(Status.FAILED);
                e.printStackTrace();
                break;
            }
        }
        if(fehler!=true){this.order.setStatus(Status.COMPLETED);}
    }

}
