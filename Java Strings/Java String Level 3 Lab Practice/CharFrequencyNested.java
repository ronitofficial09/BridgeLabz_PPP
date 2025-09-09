import java.util.Scanner;

public class CharFrequencyNested {

    // Method to find frequency of characters using nested loops
    public static String[] findFrequency(String text) {
        char[] chars = text.toCharArray();      // store characters
        int[] freq = new int[chars.length];     // frequency array

        // Outer loop for each character
        for (int i = 0; i < chars.length; i++) {
            freq[i] = 1; // initial count for this character
            if (chars[i] == '0') {
                continue; // skip already counted characters
            }

            // Inner loop to find duplicates
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0'; // mark duplicate as visited
                }
            }
        }

        // Build result array of character-frequency pairs
        String[] result = new String[chars.length];
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                result[index] = chars[i] + " -> " + freq[i];
                index++;
            }
        }

        // Trim unused null values
        String[] trimmedResult = new String[index];
        for (int i = 0; i < index; i++) {
            trimmedResult[i] = result[i];
        }

        return trimmedResult;
    }

    // Method to display result
    public static void display(String[] data) {
        System.out.println("\nCharacter | Frequency");
        System.out.println("---------------------");
        for (String entry : data) {
            String[] parts = entry.split(" -> ");
            System.out.printf("    %s     |     %s\n", parts[0], parts[1]);
        }
    }

    // Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        String[] freqData = findFrequency(text);

        display(freqData);

        sc.close();
    }
}

