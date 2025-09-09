import java.util.*;

class CartItem {
    String itemName;
    double price;
    int quantity;

    CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    double totalCost() {
        return price * quantity;
    }
}

class ShoppingCart {
    ArrayList<CartItem> cart = new ArrayList<>();

    void addItem(CartItem item) {
        cart.add(item);
        System.out.println(item.itemName + " added to cart.");
    }

    void removeItem(String itemName) {
        cart.removeIf(item -> item.itemName.equalsIgnoreCase(itemName));
        System.out.println(itemName + " removed from cart.");
    }

    void displayTotalCost() {
        double total = 0;
        for (CartItem item : cart) {
            total += item.totalCost();
        }
        System.out.println("Total Cart Cost: " + total);
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new CartItem("Laptop", 55000, 1));
        cart.addItem(new CartItem("Mouse", 500, 2));
        cart.displayTotalCost();
        cart.removeItem("Mouse");
        cart.displayTotalCost();
    }
}