import java.util.Scanner;

public class StringIndexDemo {

    // Method to generate the Exception (no handling)
    public static void generateException(String str) {
        // Accessing an index beyond the length of the string
        System.out.println("Generating Exception...");
        // This will abruptly stop the program if not handled
        char ch = str.charAt(str.length()); // invalid index
        System.out.println("Character at invalid index: " + ch);
    }

    // Method to handle the Exception using try-catch
    public static void handleException(String str) {
        try {
            System.out.println("Handling Exception with try-catch...");
            char ch = str.charAt(str.length()); // invalid index
            System.out.println("Character at invalid index: " + ch);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception caught: " + e);
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input for string
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // First, call the method that generates the Exception
        try {
            generateException(input);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Program stopped due to unhandled exception in generateException().");
        }

        // Now, call the method that handles the Exception
        handleException(input);

        sc.close();
    }
}

