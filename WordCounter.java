import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class WordCounter {
    private static final String STOP_WORDS = "the, of, to, and, a, in, is, you, that, it";
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a text or provide a file: ");
        String input = scanner.nextLine();

        if (input.startsWith("file:")) {
            File file = new File(input.substring(5));
            if (!file.exists()) {
                System.out.println("File does not exist.");
                return;
            }
            scanner = new Scanner(file);
        }
        String[] words = input.split("\\W+");
        int wordCount = 0;
        for (String word : words) {
            if (!STOP_WORDS.contains(word)) {
                wordCount++;
            }
        }
        System.out.println("The number of words is: " + wordCount);
    }
}
