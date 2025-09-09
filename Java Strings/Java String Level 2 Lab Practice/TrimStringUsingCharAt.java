import java.util.Scanner;

public class TrimStringUsingCharAt {

    // Method to find start and end indexes after trimming spaces
    public static int[] findTrimIndexes(String text) {
        int start = 0;
        int end = text.length() - 1;

        // Trim leading spaces
        while (start <= end && text.charAt(start) == ' ') {
            start++;
        }

        // Trim trailing spaces
        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }

        // return as [start, end]
        return new int[]{start, end};
    }

    // Method to create substring using charAt
    public static String substringUsingCharAt(String text, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            sb.append(text.charAt(i));
        }
        return sb.toString();
    }

    // Method to compare two strings using charAt
    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input with leading and trailing spaces
        System.out.print("Enter a string with leading and trailing spaces: ");
        String text = sc.nextLine();

        // Step 1: find trim indexes
        int[] indexes = findTrimIndexes(text);

        // Step 2: extract substring manually using charAt
        String trimmedUserDefined = substringUsingCharAt(text, indexes[0], indexes[1]);

        // Step 3: use built-in trim
        String trimmedBuiltIn = text.trim();

        // Step 4: compare results
        boolean areEqual = compareStrings(trimmedUserDefined, trimmedBuiltIn);

        // Display results
        System.out.println("\nUser-defined trim: [" + trimmedUserDefined + "]");
        System.out.println("Built-in trim:    [" + trimmedBuiltIn + "]");
        System.out.println("Are both results same? " + areEqual);

        sc.close();
    }
}
