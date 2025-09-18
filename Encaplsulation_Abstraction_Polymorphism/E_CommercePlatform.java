import java.util.ArrayList;
import java.util.List;

// Abstraction & Encapsulation
abstract class Product {
    private String productId;
    private String name;
    private double price;

    public abstract double calculateDiscount();

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }
    }

    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: $" + String.format("%.2f", price));
    }
}

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

class Electronics extends Product implements Taxable {
    private double taxRate;
    private double discountPercentage;

    public Electronics(String productId, String name, double price, double taxRate, double discountPercentage) {
        super(productId, name, price); 
        this.taxRate = taxRate;
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * discountPercentage;
    }

    @Override
    public double calculateTax() {
        return getPrice() * taxRate;
    }

    @Override
    public String getTaxDetails() {
        return "Tax Rate: " + (taxRate * 100) + "%";
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Discount: $" + String.format("%.2f", calculateDiscount()));
        System.out.println(getTaxDetails());
    }
}

class Clothing extends Product {
    private double discountPercentage;

    public Clothing(String productId, String name, double price, double discountPercentage) {
        super(productId, name, price); 
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * discountPercentage;
    }
}

class Groceries extends Product implements Taxable {
    private double taxRate;
    private double discountAmount;

    public Groceries(String productId, String name, double price, double taxRate, double discountAmount) {
        super(productId, name, price); 
        this.taxRate = taxRate;
        this.discountAmount = discountAmount;
    }

    @Override
    public double calculateDiscount() {
        return discountAmount;
    }

  
    @Override
    public double calculateTax() {
        return getPrice() * taxRate;
    }

    @Override
    public String getTaxDetails() {
        return "Tax Rate: " + (taxRate * 100) + "%";
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Discount: $" + String.format("%.2f", calculateDiscount()));
        System.out.println(getTaxDetails());
    }
}


public class E_CommercePlatform {
    public static void main(String[] args) {
        // Polymorphism
        List<Product> products = new ArrayList<>();

    
        Electronics laptop = new Electronics("E001", "Laptop", 12000.00, 0.08, 0.15);
        Clothing shirt = new Clothing("C201", "T-Shirt", 25.00, 0.20);
        Groceries apples = new Groceries("G301", "Apples", 5.00, 0.05, 1.00);

        
        products.add(laptop);
        products.add(shirt);
        products.add(apples);

        System.out.println("--- Product Catalog ---");
        
        for (Product product : products) {
            product.displayDetails();
            System.out.println("Final Price (after discount): $" + String.format("%.2f", (product.getPrice() - product.calculateDiscount())));
            
            // Polymorphism 
            if (product instanceof Taxable) {
                Taxable taxableProduct = (Taxable) product;
                System.out.println("Applicable Tax: $" + String.format("%.2f", taxableProduct.calculateTax()));
            }
        }
    }
}
