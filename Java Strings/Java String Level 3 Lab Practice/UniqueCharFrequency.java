import java.util.Scanner;

public class UniqueCharFrequency {

    // Method to find unique characters in a string
    public static char[] uniqueCharacters(String text) {
        char[] temp = new char[text.length()];
        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            boolean isUnique = true;

            // check if character is already in temp
            for (int j = 0; j < count; j++) {
                if (temp[j] == c) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                temp[count] = c;
                count++;
            }
        }

        // Create an array with exact size
        char[] unique = new char[count];
        for (int i = 0; i < count; i++) {
            unique[i] = temp[i];
        }

        return unique;
    }

    // Method to find frequency using unique characters
    public static String[][] findFrequency(String text) {
        // frequency array for ASCII
        int[] freq = new int[256];

        // Count frequencies
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        // Get unique characters
        char[] unique = uniqueCharacters(text);

        // Prepare result array
        String[][] result = new String[unique.length][2];
        for (int i = 0; i < unique.length; i++) {
            result[i][0] = String.valueOf(unique[i]);
            result[i][1] = String.valueOf(freq[unique[i]]);
        }

        return result;
    }

    // Method to display results
    public static void displayResult(String[][] data) {
        System.out.println("\nCharacter | Frequency");
        System.out.println("---------------------");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("    %s     |     %s\n", data[i][0], data[i][1]);
        }
    }

    // Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        String[][] freqData = findFrequency(text);

        displayResult(freqData);

        sc.close();
    }
}

