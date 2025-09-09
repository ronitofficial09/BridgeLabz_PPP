import java.util.Scanner;

public class TeamBMI {

    // Method to compute BMI and Status
    public static String[] computeBMI(double weight, double heightCm) {
        double heightM = heightCm / 100.0; // convert cm to m
        double bmi = weight / (heightM * heightM);

        // Round BMI to 2 decimal places
        bmi = Math.round(bmi * 100.0) / 100.0;

        String status;
        if (bmi < 18.5) {
            status = "Underweight";
        } else if (bmi < 24.9) {
            status = "Normal";
        } else if (bmi < 29.9) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        return new String[]{String.valueOf(bmi), status};
    }

    // Method to compute BMI for all persons
    public static String[][] buildBMIReport(double[][] hwArray) {
        int n = hwArray.length;
        String[][] report = new String[n][4]; // height, weight, BMI, status

        for (int i = 0; i < n; i++) {
            double weight = hwArray[i][0];
            double height = hwArray[i][1];

            String[] bmiStatus = computeBMI(weight, height);

            report[i][0] = String.valueOf(height); // Height in cm
            report[i][1] = String.valueOf(weight); // Weight in kg
            report[i][2] = bmiStatus[0];           // BMI
            report[i][3] = bmiStatus[1];           // Status
        }
        return report;
    }

    // Method to display in tabular format
    public static void displayReport(String[][] report) {
        System.out.printf("%-10s %-10s %-10s %-15s%n", "Height(cm)", "Weight(kg)", "BMI", "Status");
        System.out.println("------------------------------------------------------");

        for (int i = 0; i < report.length; i++) {
            System.out.printf("%-10s %-10s %-10s %-15s%n",
                    report[i][0], report[i][1], report[i][2], report[i][3]);
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 10; // team of 10 members
        double[][] hwArray = new double[n][2]; // col[0]=weight, col[1]=height

        System.out.println("Enter weight (kg) and height (cm) for " + n + " persons:");

        for (int i = 0; i < n; i++) {
            System.out.print("Person " + (i + 1) + " - Weight (kg): ");
            hwArray[i][0] = sc.nextDouble();

            System.out.print("Person " + (i + 1) + " - Height (cm): ");
            hwArray[i][1] = sc.nextDouble();
        }

        String[][] report = buildBMIReport(hwArray);

        System.out.println("\n--- BMI Report of Team ---");
        displayReport(report);

        sc.close();
    }
}

