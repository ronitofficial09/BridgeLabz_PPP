import java.util.Scanner;

public class SubstringCompare {

    // Method to create substring manually using charAt()
    public static String createSubstring(String text, int start, int end) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i < end; i++) {
            result.append(text.charAt(i));
        }
        return result.toString();
    }

    // Method to compare two strings manually using charAt()
    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a string: ");
        String text = sc.next();

        System.out.print("Enter start index: ");
        int start = sc.nextInt();

        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        // Validate indices
        if (start < 0 || end > text.length() || start >= end) {
            System.out.println("❌ Invalid indices provided.");
            sc.close();
            return;
        }

        // Substring using manual method
        String manualSubstring = createSubstring(text, start, end);

        // Substring using built-in method
        String builtinSubstring = text.substring(start, end);

        // Compare both substrings
        boolean comparisonResult = compareStrings(manualSubstring, builtinSubstring);

        // Display results
        System.out.println("\nSubstring using charAt(): " + manualSubstring);
        System.out.println("Substring using built-in method: " + builtinSubstring);
        System.out.println("Are both substrings equal? " + comparisonResult);

        sc.close();
    }
}
