import java.util.Scanner;

public class IllegalArgumentDemo {

    public static void generateException(String str) {
        System.out.println("Substring: " + str.substring(5, 2));
    }

    public static void handleException(String str) {
        try {
            System.out.println("Substring: " + str.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: Start index cannot be greater than end index!");
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.println("\n--- Generating Exception (without handling) ---");

        System.out.println("\n--- Handling Exception (with try-catch) ---");
        handleException(input);

        sc.close();
    }
}
