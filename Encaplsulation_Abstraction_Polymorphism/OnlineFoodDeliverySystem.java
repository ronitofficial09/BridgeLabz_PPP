import java.util.ArrayList;
import java.util.List;

// Abstraction & Encapsulation
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    // Abstraction
    public abstract double calculateTotalPrice();

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Concrete method for item details
    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price per unit: $" + String.format("%.2f", price));
        System.out.println("Quantity: " + quantity);
    }

    // Encapsulation
    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

// Abstraction
interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

// Inheritance & Abstraction
class VegItem extends FoodItem implements Discountable {
    private double discountPercentage = 0.10;

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    // Abstraction
    @Override
    public double calculateTotalPrice() {
        double subtotal = getPrice() * getQuantity();
        return subtotal - applyDiscount();
    }
    
    // Abstraction
    @Override
    public double applyDiscount() {
        return (getPrice() * getQuantity()) * discountPercentage;
    }

    @Override
    public String getDiscountDetails() {
        return "Special Veg Discount (" + (int)(discountPercentage * 100) + "%) applied";
    }

    @Override
    public void getItemDetails() {
        super.getItemDetails();
        System.out.println("Category: Vegetarian");
    }
}

// Inheritance & Abstraction
class NonVegItem extends FoodItem {
    private static final double SURCHARGE_RATE = 1.50;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    // Abstraction
    @Override
    public double calculateTotalPrice() {
        double subtotal = getPrice() * getQuantity();
        return subtotal + (getQuantity() * SURCHARGE_RATE);
    }

    @Override
    public void getItemDetails() {
        super.getItemDetails();
        System.out.println("Category: Non-Vegetarian");
    }
}

// Main class to demonstrate the system
public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        // Polymorphism
        List<FoodItem> order = new ArrayList<>();

        // Creating instances of concrete classes
        VegItem pizza = new VegItem("Margherita Pizza", 12.50, 2);
        NonVegItem chickenCurry = new NonVegItem("Chicken Curry", 15.00, 1);
        VegItem salad = new VegItem("Garden Salad", 7.00, 3);

        // Adding items to the order
        order.add(pizza);
        order.add(chickenCurry);
        order.add(salad);

        System.out.println("--- Your Order Details ---");
        double grandTotal = 0;

        // Polymorphism
        for (FoodItem item : order) {
            item.getItemDetails();
            double totalPrice = item.calculateTotalPrice();
            System.out.println("Item Subtotal: $" + String.format("%.2f", totalPrice));

            // Polymorphism with the Discountable interface
            if (item instanceof Discountable) {
                Discountable discountItem = (Discountable) item;
                System.out.println(discountItem.getDiscountDetails());
            }

            // Demonstrate additional charges for NonVegItem
            if (item instanceof NonVegItem) {
                System.out.println("A $" + String.format("%.2f", ((NonVegItem) item).getQuantity() * 1.50) + " non-veg surcharge has been added.");
            }
            
            grandTotal += totalPrice;
            System.out.println("---------------------------------");
        }
        System.out.println("Grand Total for the order: $" + String.format("%.2f", grandTotal));
    }
}