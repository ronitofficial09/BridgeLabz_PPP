import java.util.Scanner;

public class MaxOfThree {

    public static int getInput(Scanner sc) {
        return sc.nextInt();
    }

    public static int findMax(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter three numbers: ");
        int a = getInput(sc);
        int b = getInput(sc);
        int c = getInput(sc);

        System.out.println("Maximum: " + findMax(a, b, c));
    }
}
