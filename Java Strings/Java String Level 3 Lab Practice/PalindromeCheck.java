import java.util.Scanner;

public class PalindromeCheck {

    // Logic 1: Iterative check from start and end
    public static boolean isPalindromeIterative(String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Logic 2: Recursive check
    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    // Helper method: Reverse string using charAt()
    public static char[] reverseString(String text) {
        char[] reversed = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            reversed[i] = text.charAt(text.length() - 1 - i);
        }
        return reversed;
    }

    // Logic 3: Using char arrays and reverse
    public static boolean isPalindromeCharArray(String text) {
        char[] original = text.toCharArray();
        char[] reversed = reverseString(text);

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a text: ");
        String text = sc.nextLine();

        // Logic 1: Iterative
        boolean result1 = isPalindromeIterative(text);

        // Logic 2: Recursive
        boolean result2 = isPalindromeRecursive(text, 0, text.length() - 1);

        // Logic 3: Char Array
        boolean result3 = isPalindromeCharArray(text);

        // Display Results
        System.out.println("\nPalindrome Check Results:");
        System.out.println("-------------------------");
        System.out.println("Logic 1 (Iterative) : " + (result1 ? "Palindrome" : "Not Palindrome"));
        System.out.println("Logic 2 (Recursive) : " + (result2 ? "Palindrome" : "Not Palindrome"));
        System.out.println("Logic 3 (CharArray) : " + (result3 ? "Palindrome" : "Not Palindrome"));

        sc.close();
    }
}

