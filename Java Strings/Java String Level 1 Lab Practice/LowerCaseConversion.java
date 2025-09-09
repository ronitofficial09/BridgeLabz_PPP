import java.util.Scanner;

public class LowerCaseConversion {

    public static String toLowerCaseManual(String text) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                result.append((char)(ch + 32));
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

        String manualLower = toLowerCaseManual(text);

        String builtInLower = text.toLowerCase();

        boolean areSame = compareStrings(manualLower, builtInLower);

        System.out.println("\nOriginal Text: " + text);
        System.out.println("Manual Lowercase Conversion: " + manualLower);
        System.out.println("Built-in Lowercase Conversion: " + builtInLower);
        System.out.println("Are both results same? " + areSame);

        sc.close();
    }
}
