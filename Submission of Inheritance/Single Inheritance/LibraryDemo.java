class Book {
    String title;
    int publicationYear;

    Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    void displayInfo() {
        System.out.println("Book: " + title + " (" + publicationYear + ")");
    }
}

class Author extends Book {
    String name;
    String bio;

    Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Author: " + name + " | Bio: " + bio);
    }
}

public class LibraryDemo {
    public static void main(String[] args) {
        Author a1 = new Author("Java Basics", 2021, "John Smith", "Expert in Java Programming");
        a1.displayInfo();
    }
} 