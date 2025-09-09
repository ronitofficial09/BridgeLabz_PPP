import java.util.Scanner;

public class StringCompare {

    // Method to compare two strings using charAt()
    public static boolean compareStrings(String str1, String str2) {
        // If lengths are different, return false
        if (str1.length() != str2.length()) {
            return false;
        }

        // Compare characters one by one
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true; // All characters matched
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input for two strings
        System.out.print("Enter first string: ");
        String str1 = sc.next();

        System.out.print("Enter second string: ");
        String str2 = sc.next();

        // Compare using custom method
        boolean charAtResult = compareStrings(str1, str2);

        // Compare using built-in equals() method
        boolean equalsResult = str1.equals(str2);

        // Display results
        System.out.println("\nComparison using charAt() method: " + charAtResult);
        System.out.println("Comparison using equals() method: " + equalsResult);

        // Check if both results are the same
        if (charAtResult == equalsResult) {
            System.out.println("✅ Both methods give the SAME result.");
        } else {
            System.out.println("❌ Results are DIFFERENT.");
        }

        sc.close();
    }
}
