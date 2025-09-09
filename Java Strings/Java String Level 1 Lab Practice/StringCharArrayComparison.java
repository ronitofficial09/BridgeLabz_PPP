import java.util.Scanner;

public class StringCharArrayComparison {

    // User-defined method to convert a string to char array
    public static char[] convertToCharArray(String str) {
        char[] result = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            result[i] = str.charAt(i);
        }
        return result;
    }

    // Method to compare two char arrays
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter a string: ");
        String input = sc.next();

        // Calling user-defined method
        char[] customArray = convertToCharArray(input);

        // Using built-in toCharArray method
        char[] builtInArray = input.toCharArray();

        // Compare the two arrays
        boolean isEqual = compareCharArrays(customArray, builtInArray);

        // Displaying results
        System.out.println("\nCharacters from custom method:");
        for (char c : customArray) {
            System.out.print(c + " ");
        }

        System.out.println("\nCharacters from built-in method:");
        for (char c : builtInArray) {
            System.out.print(c + " ");
        }

        System.out.println("\n\nComparison Result: " + (isEqual ? "Arrays are Equal ✅" : "Arrays are NOT Equal ❌"));

        sc.close();
    }
}

