// Create a program to find the mean height of players present in a football team.
// Hint => 
// The formula to calculate the mean is: mean = sum of all elements / number of elements
// Create a double array named heights of size 11 and get input values from the user.
// Find the sum of all the elements present in the array.
// Divide the sum by 11 to find the mean height and print the mean height of the football team

import java.util.Scanner;

public class MeanHeight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double[] heights = new double[11];
        double sum = 0.0;

        System.out.println("Enter the heights of 11 football players:");
        for (int i = 0; i < heights.length; i++) {
            while (true) {
                System.out.print("Height of player " + (i + 1) + ": ");
                double input = sc.nextDouble();
                if (input >= 0) {
                    heights[i] = input;
                    sum += input;
                    break;
                } else {
                    System.out.println("Invalid height! Height cannot be negative. Please enter again.");
                }
            }
        }

        double mean = sum / heights.length;

        System.out.println("\nThe mean height of the football team is: " + mean);

        sc.close();
    }
}
