import java.util.*;
import java.io.File;
public class WordCounter {
    private static String Stopwords = "the, of, to, and, a, in,is, you, that, it"; 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a text or provide a file: ");
        String input = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        if (input.startsWith("file:")) {
            File file = new File(input.substring(5));
            if (!file.exists()) {
                System.out.println("File does not exist");
                return;
            }
            try (Scanner fileScanner = new Scanner(file)) {
                while (fileScanner.hasNextLine()) {
                    sb.append(fileScanner.nextLine());
                }
            } catch (Exception e) {
                System.out.println("Error reading file: " + e.getMessage());
                return;
            }
        } else {
            sb.append(input);
        }
        String[] words = sb.toString().split("\\W+");
        int wordCount = 0;
        for (String word : words) {
            word = word.toLowerCase();
            if (!Stopwords.contains(word)) {
                wordCount++;
            }
        }
        System.out.println("The number of words is: " + wordCount);
    }
}
