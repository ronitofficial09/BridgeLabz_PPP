import java.util.Scanner;

public class StudentScoreCard {

    // Method to generate random 2-digit scores for PCM subjects
    public static int[][] generateScores(int numStudents) {
        int[][] scores = new int[numStudents][3]; // 3 subjects: Physics, Chemistry, Maths
        for (int i = 0; i < numStudents; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = (int) (Math.random() * 41) + 60; // random score between 60–100
            }
        }
        return scores;
    }

    // Method to calculate total, average, percentage
    public static double[][] calculateResults(int[][] scores) {
        int numStudents = scores.length;
        double[][] results = new double[numStudents][3]; 
        // col[0]=total, col[1]=average, col[2]=percentage

        for (int i = 0; i < numStudents; i++) {
            int total = 0;
            for (int j = 0; j < 3; j++) {
                total += scores[i][j];
            }
            double avg = total / 3.0;
            double perc = (total / 300.0) * 100.0;

            // Round off to 2 digits
            avg = Math.round(avg * 100.0) / 100.0;
            perc = Math.round(perc * 100.0) / 100.0;

            results[i][0] = total;
            results[i][1] = avg;
            results[i][2] = perc;
        }
        return results;
    }

    // Method to calculate grade
    public static String[] calculateGrades(double[][] results) {
        int numStudents = results.length;
        String[] grades = new String[numStudents];

        for (int i = 0; i < numStudents; i++) {
            double perc = results[i][2];
            if (perc >= 90) grades[i] = "A+";
            else if (perc >= 80) grades[i] = "A";
            else if (perc >= 70) grades[i] = "B";
            else if (perc >= 60) grades[i] = "C";
            else if (perc >= 50) grades[i] = "D";
            else grades[i] = "F";
        }
        return grades;
    }

    // Method to display scorecard
    public static void displayScoreCard(int[][] scores, double[][] results, String[] grades) {
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-12s %-8s%n",
                "Student", "Physics", "Chemistry", "Maths", "Total", "Average", "Percentage", "Grade");
        System.out.println("------------------------------------------------------------------------------------------");

        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-10d %-10d %-10d %-10d %-10.0f %-10.2f %-12.2f %-8s%n",
                    (i + 1), scores[i][0], scores[i][1], scores[i][2],
                    results[i][0], results[i][1], results[i][2], grades[i]);
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] scores = generateScores(n);
        double[][] results = calculateResults(scores);
        String[] grades = calculateGrades(results);

        displayScoreCard(scores, results, grades);

        sc.close();
    }
}

