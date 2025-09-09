import java.util.Scanner;

public class CharFrequency {

    // Method to find frequency of characters in a string
    public static String[][] findFrequency(String text) {
        int[] freq = new int[256]; // frequency array for ASCII chars

        // Count frequency
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            freq[c]++;
        }

        // Count how many unique characters exist
        int uniqueCount = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                uniqueCount++;
            }
        }

        // Create 2D array to store char and frequency
        String[][] result = new String[uniqueCount][2];
        int index = 0;

        // Fill result array
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (freq[c] > 0) {
                result[index][0] = String.valueOf(c);
                result[index][1] = String.valueOf(freq[c]);
                freq[c] = 0; // avoid duplicates
                index++;
            }
        }

        return result;
    }

    // Method to display the 2D array in tabular format
    public static void displayResult(String[][] data) {
        System.out.println("\nCharacter | Frequency");
        System.out.println("---------------------");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("    %s     |     %s\n", data[i][0], data[i][1]);
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        String[][] freqData = findFrequency(text);

        displayResult(freqData);

        sc.close();
    }
}
