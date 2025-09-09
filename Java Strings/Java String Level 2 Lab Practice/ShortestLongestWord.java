import java.util.Scanner;

public class ShortestLongestWord {

    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // loop stops when out of bounds
        }
        return count;
    }

    public static String[] splitText(String text) {
        int length = findLength(text);

        int wordCount = 1;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        String[] words = new String[wordCount];
        int start = 0, wordIndex = 0;
        for (int i = 0; i <= length; i++) {
            if (i == length || text.charAt(i) == ' ') {
                StringBuilder word = new StringBuilder();
                for (int j = start; j < i; j++) {
                    word.append(text.charAt(j));
                }
                words[wordIndex++] = word.toString();
                start = i + 1;
            }
        }
        return words;
    }

    public static String[][] wordsWithLength(String[] words) {
        int n = words.length;
        String[][] result = new String[n][2];

        for (int i = 0; i < n; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }
        return result;
    }

    public static int[] findShortestLongest(String[][] wordData) {
        int shortestIndex = 0;
        int longestIndex = 0;

        for (int i = 1; i < wordData.length; i++) {
            int length = Integer.parseInt(wordData[i][1]);
            int shortestLength = Integer.parseInt(wordData[shortestIndex][1]);
            int longestLength = Integer.parseInt(wordData[longestIndex][1]);

            if (length < shortestLength) {
                shortestIndex = i;
            }
            if (length > longestLength) {
                longestIndex = i;
            }
        }
        return new int[]{shortestIndex, longestIndex};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a text: ");
        String text = sc.nextLine();

        String[] words = splitText(text);

        String[][] wordsWithLengths = wordsWithLength(words);

        int[] result = findShortestLongest(wordsWithLengths);

        System.out.println("\nWord\tLength");
        System.out.println("-----------------");
        for (int i = 0; i < wordsWithLengths.length; i++) {
            String word = wordsWithLengths[i][0];
            int length = Integer.parseInt(wordsWithLengths[i][1]);
            System.out.println(word + "\t" + length);
        }
        System.out.println("\nShortest Word: " + wordsWithLengths[result[0]][0] +
                           " (Length: " + wordsWithLengths[result[0]][1] + ")");
        System.out.println("Longest Word: " + wordsWithLengths[result[1]][0] +
                           " (Length: " + wordsWithLengths[result[1]][1] + ")");

        sc.close();
    }
}
