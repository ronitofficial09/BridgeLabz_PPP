import java.util.Random;
import java.util.Scanner;

public class StudentVotingEligibility {

    // Method to generate random 2-digit ages
    public static int[] generateAges(int n) {
        Random rand = new Random();
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) {
            // random 2-digit age between 10 and 99
            ages[i] = rand.nextInt(90) + 10;
        }
        return ages;
    }

    // Method to check voting eligibility
    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            if (ages[i] < 0) {
                result[i][1] = "false (Invalid Age)";
            } else if (ages[i] >= 18) {
                result[i][1] = "true";
            } else {
                result[i][1] = "false";
            }
        }
        return result;
    }

    // Method to display results in a tabular format
    public static void displayTable(String[][] data) {
        System.out.printf("%-10s %-15s%n", "Age", "Can Vote?");
        System.out.println("--------------------------");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%-10s %-15s%n", data[i][0], data[i][1]);
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ask user how many students
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        // Step 1: Generate ages
        int[] ages = generateAges(n);

        // Step 2: Check voting eligibility
        String[][] votingTable = checkVotingEligibility(ages);

        // Step 3: Display results
        displayTable(votingTable);

        sc.close();
    }
}
