import java.util.Scanner;

public class RockPaperScissorsGame {

    // Method to get computer's choice
    public static String getComputerChoice() {
        int choice = (int)(Math.random() * 3); // 0, 1, or 2
        switch (choice) {
            case 0: return "rock";
            case 1: return "paper";
            default: return "scissors";
        }
    }

    // Method to determine winner
    public static String findWinner(String userChoice, String compChoice) {
        if (userChoice.equals(compChoice)) {
            return "draw";
        }
        if (userChoice.equals("rock") && compChoice.equals("scissors") ||
            userChoice.equals("scissors") && compChoice.equals("paper") ||
            userChoice.equals("paper") && compChoice.equals("rock")) {
            return "user";
        }
        return "computer";
    }

    // Method to calculate percentages
    public static String[][] calculateStats(int userWins, int compWins, int draws, int totalGames) {
        String[][] stats = new String[2][3]; // 2 rows: user & computer, 3 cols: wins, % wins, draws ignored
        stats[0][0] = "User";
        stats[0][1] = String.valueOf(userWins);
        stats[0][2] = String.format("%.2f%%", (userWins * 100.0 / totalGames));

        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(compWins);
        stats[1][2] = String.format("%.2f%%", (compWins * 100.0 / totalGames));

        return stats;
    }

    // Method to display results
    public static void displayResults(String[][] gameResults, String[][] stats) {
        System.out.printf("%-10s %-15s %-15s %-10s%n", "Game", "User Choice", "Computer Choice", "Winner");
        System.out.println("----------------------------------------------------------");
        for (int i = 0; i < gameResults.length; i++) {
            System.out.printf("%-10s %-15s %-15s %-10s%n",
                    (i + 1), gameResults[i][0], gameResults[i][1], gameResults[i][2]);
        }

        System.out.println("\n=== Final Statistics ===");
        System.out.printf("%-10s %-10s %-10s%n", "Player", "Wins", "Win %");
        System.out.println("----------------------------------");
        for (int i = 0; i < stats.length; i++) {
            System.out.printf("%-10s %-10s %-10s%n", stats[i][0], stats[i][1], stats[i][2]);
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of games to play: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[][] gameResults = new String[n][3]; // user choice, computer choice, winner
        int userWins = 0, compWins = 0, draws = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter your choice (rock, paper, scissors): ");
            String userChoice = sc.nextLine().toLowerCase();
            String compChoice = getComputerChoice();

            String winner = findWinner(userChoice, compChoice);
            if (winner.equals("user")) userWins++;
            else if (winner.equals("computer")) compWins++;
            else draws++;

            gameResults[i][0] = userChoice;
            gameResults[i][1] = compChoice;
            gameResults[i][2] = winner;
        }

        String[][] stats = calculateStats(userWins, compWins, draws, n);
        displayResults(gameResults, stats);

        sc.close();
    }
}