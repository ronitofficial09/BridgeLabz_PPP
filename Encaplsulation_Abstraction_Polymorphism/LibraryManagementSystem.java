import java.util.ArrayList;
import java.util.List;

// Abstraction & Encapsulation
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    // Abstraction
    public abstract int getLoanDuration();

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Concrete method for item details
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
    
    // Encapsulation
    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}

// Abstraction
interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

// Inheritance & Abstraction
class Book extends LibraryItem implements Reservable {
    private String borrower;
    private boolean isAvailable = true;

    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    // Abstraction
    @Override
    public int getLoanDuration() {
        return 21; 
    }
    
    // Abstraction
    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable) {
            this.borrower = borrowerName;
            this.isAvailable = false;
            System.out.println(getTitle() + " has been reserved by " + borrowerName);
        } else {
            System.out.println(getTitle() + " is currently unavailable.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }
    
    @Override
    public void getItemDetails() {
        super.getItemDetails();
        System.out.println("Type: Book");
    }
}

// Inheritance & Abstraction
class Magazine extends LibraryItem {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    // Abstraction
    @Override
    public int getLoanDuration() {
        return 7; 
    }
    
    @Override
    public void getItemDetails() {
        super.getItemDetails();
        System.out.println("Type: Magazine");
    }
}

// Inheritance & Abstraction
class DVD extends LibraryItem implements Reservable {
    private String borrower;
    private boolean isAvailable = true;

    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    // Abstraction
    @Override
    public int getLoanDuration() {
        return 14; 
    }

    // Abstraction
    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable) {
            this.borrower = borrowerName;
            this.isAvailable = false;
            System.out.println(getTitle() + " has been reserved by " + borrowerName);
        } else {
            System.out.println(getTitle() + " is currently unavailable.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }

    @Override
    public void getItemDetails() {
        super.getItemDetails();
        System.out.println("Type: DVD");
    }
}

// Main class to demonstrate the library system
public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Polymorphism
        List<LibraryItem> items = new ArrayList<>();

        // Creating instances of concrete classes
        Book fictionBook = new Book("B-101", "The Alchemist", "Paulo Coelho");
        Magazine scienceMagazine = new Magazine("M-201", "National Geographic", "Various");
        DVD movieDVD = new DVD("D-301", "Inception", "Christopher Nolan");

        // Adding items to the list
        items.add(fictionBook);
        items.add(scienceMagazine);
        items.add(movieDVD);

        System.out.println("--- Library Item Catalog ---");
        // Polymorphism
        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Standard Loan Duration: " + item.getLoanDuration() + " days");

            // Polymorphism with the Reservable interface
            if (item instanceof Reservable) {
                Reservable reservableItem = (Reservable) item;
                reservableItem.reserveItem("John Doe");
                System.out.println("Is still available? " + reservableItem.checkAvailability());
            }

            System.out.println("---------------------------------");
        }
    }
}