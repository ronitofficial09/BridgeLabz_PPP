import java.util.Scanner;

public class VowelConsonantIdentifier {

    // Method to check if a character is a vowel, consonant, or not a letter
    public static String checkCharacterType(char ch) {
        // Convert uppercase to lowercase using ASCII difference
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char)(ch + 32); // 'A'=65, 'a'=97, difference=32
        }

        // Check if it's a letter
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
        return "Not a Letter";
    }

    // Method to find vowels and consonants in a string
    public static String[][] analyzeString(String text) {
        String[][] result = new String[text.length()][2];

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            result[i][0] = String.valueOf(ch);         // Store the character
            result[i][1] = checkCharacterType(ch);     // Store the type
        }

        return result;
    }

    // Method to display results in a tabular format
    public static void displayResult(String[][] result) {
        System.out.printf("%-10s %-15s%n", "Character", "Type");
        System.out.println("-----------------------------");

        for (int i = 0; i < result.length; i++) {
            System.out.printf("%-10s %-15s%n", result[i][0], result[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input text
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        // Analyze string
        String[][] result = analyzeString(text);

        // Display in tabular form
        System.out.println("\nAnalysis of Characters:");
        displayResult(result);

        sc.close();
    }
}
