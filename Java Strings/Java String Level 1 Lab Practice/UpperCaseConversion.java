import java.util.Scanner;

public class UpperCaseConversion {

    public static String toUpperCaseManual(String text) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                result.append((char)(ch - 32));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String manualUpper = toUpperCaseManual(text);

        String builtInUpper = text.toUpperCase();

        boolean areSame = compareStrings(manualUpper, builtInUpper);

        System.out.println("\nOriginal Text: " + text);
        System.out.println("Manual Uppercase Conversion: " + manualUpper);
        System.out.println("Built-in Uppercase Conversion: " + builtInUpper);
        System.out.println("Are both results same? " + areSame);

        sc.close();
    }
}
