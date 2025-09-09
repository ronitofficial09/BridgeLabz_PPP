import java.util.Scanner;

public class StringLengthWithoutLengthMethod {
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count); 
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.next();
        int myLength = findLength(input);

        int actualLength = input.length();

        System.out.println("Length of string using user-defined method: " + myLength);
        System.out.println("Length of string using built-in method: " + actualLength);

        sc.close();
    }
}
