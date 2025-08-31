import java.util.*;

public class NumberGuessingGame {

    public static int generateGuess(int low, int high) {
        return (int) (Math.random() * (high - low + 1)) + low;
    }

    public static String getFeedback(Scanner sc) {
        System.out.print("Enter feedback (low/high/correct): ");
        return sc.next().toLowerCase();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int low = 1, high = 100;
        String feedback = "";

        System.out.println("Think of a number between 1 and 100!");
        while (!feedback.equals("correct")) {
            int guess = generateGuess(low, high);
            System.out.println("Computer guesses: " + guess);
            feedback = getFeedback(sc);

            if (feedback.equals("low")) {
                low = guess + 1;
            } else if (feedback.equals("high")) {
                high = guess - 1;
            }
        }
        System.out.println("Yay! Computer guessed your number!");
    }
}
