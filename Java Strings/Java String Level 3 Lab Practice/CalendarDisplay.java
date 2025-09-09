import java.util.Scanner;

public class CalendarDisplay {

    // Method to get month name
    public static String getMonthName(int month) {
        String[] months = {"January", "February", "March", "April", "May", "June",
                           "July", "August", "September", "October", "November", "December"};
        return months[month - 1];
    }

    // Method to check for leap year
    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
    }

    // Method to get number of days in the month
    public static int getNumberOfDays(int month, int year) {
        int[] days = {31, 28, 31, 30, 31, 30,
                      31, 31, 30, 31, 30, 31};

        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return days[month - 1];
    }

    // Method to get first day of the month using Gregorian calendar algorithm
    public static int getFirstDay(int month, int year) {
        int d = 1; // Day = 1 (first day of month)
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0/4 - y0/100 + y0/400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        return (d + x + (31*m0)/12) % 7; // 0=Sunday, 1=Monday,...
    }

    // Method to display calendar
    public static void displayCalendar(int month, int year) {
        // Print heading
        System.out.println("    " + getMonthName(month) + " " + year);
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");

        // Find first day
        int startDay = getFirstDay(month, year);
        int numDays = getNumberOfDays(month, year);

        // First loop for indentation before day 1
        for (int i = 0; i < startDay; i++) {
            System.out.print("    ");
        }

        // Second loop to print all days
        for (int day = 1; day <= numDays; day++) {
            System.out.printf("%4d", day);
            if ((day + startDay) % 7 == 0) {
                System.out.println(); // new line after Saturday
            }
        }
        System.out.println(); // final line break
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();

        System.out.print("Enter year: ");
        int year = sc.nextInt();

        // Display calendar
        displayCalendar(month, year);

        sc.close();
    }
}

