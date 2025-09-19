import java.util.*;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
}

class Order {
    private int orderId;
    private List<Product> products;

    public Order(int orderId) {
        this.orderId = orderId;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double calculateTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.getPrice();
        }
        return total;
    }

    public void showOrder() {
        System.out.println("Order #" + orderId);
        for (Product p : products) {
            System.out.println(" - " + p.getName() + " : $" + p.getPrice());
        }
        System.out.println("Total: $" + calculateTotal());
    }
}

class Customer {
    private String name;
    private List<Order> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println("Customer " + name + " placed Order #" + order.hashCode());
    }

    public void showOrders() {
        System.out.println("Customer: " + name);
        for (Order o : orders) {
            o.showOrder();
        }
    }
}

public class ECommerceData {
    public static void main(String[] args) {
        Customer customer = new Customer("BhanuPratap Singh");

        Product p1 = new Product("Laptop", 76000);
        Product p2 = new Product("Mouse", 670);

        Order order = new Order(1);
        order.addProduct(p1);
        order.addProduct(p2);

        customer.placeOrder(order);
        customer.showOrders();
    }
}
