class Order {
    int orderId;
    String orderDate;

    Order(int orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    void getOrderStatus() {
        System.out.println("Order placed. ID: " + orderId + ", Date: " + orderDate);
    }
}

class ShippedOrder extends Order {
    String trackingNumber;

    ShippedOrder(int orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    void getOrderStatus() {
        super.getOrderStatus();
        System.out.println("Order shipped. Tracking Number: " + trackingNumber);
    }
}

class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    DeliveredOrder(int orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    void getOrderStatus() {
        super.getOrderStatus();
        System.out.println("Order delivered on: " + deliveryDate);
    }
}

public class OrderDemo {
    public static void main(String[] args) {
        DeliveredOrder d1 = new DeliveredOrder(1001, "2025-09-17", "TR12345", "2025-09-20");
        d1.getOrderStatus();
    }
} 