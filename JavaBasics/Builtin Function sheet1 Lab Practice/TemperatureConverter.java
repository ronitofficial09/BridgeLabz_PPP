import java.util.Scanner;

public class TemperatureConverter {

    public static double toCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    public static double toFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter temperature: ");
        double temp = sc.nextDouble();
        System.out.print("Convert to (C/F): ");
        char choice = sc.next().toUpperCase().charAt(0);

        if (choice == 'C')
            System.out.println("In Celsius: " + toCelsius(temp));
        else if (choice == 'F')
            System.out.println("In Fahrenheit: " + toFahrenheit(temp));
        else
            System.out.println("Invalid choice!");
    }
}
