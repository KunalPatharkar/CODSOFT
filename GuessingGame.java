import java.util.*;
public class GuessingGame {
    static int Min_numbers = 1;
    static int Max_numbers = 100;
    static int Max_attempts = 10;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalScore = 0;
        String playAgain = "Y";
        while (playAgain.equalsIgnoreCase("Y")) {
            int number = new Random().nextInt(Max_numbers - Min_numbers + 1) + Min_numbers;
            int attempts = 0;
            int guess;
            do {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
                if (guess == number) {
                    System.out.println("Congratulations!! You guessed the number correctly.");
                    break;
                } else if (guess < number) {
                    System.out.println("Your guess is too low");
                } else {
                    System.out.println("Your guess is too high");
                }
                attempts++;
            } while (attempts < Max_attempts);
            int score = Max_attempts - attempts;
            totalScore += score;
            System.out.println("Your total score is: " + totalScore);
            System.out.print("Do you want to play again? (Y/N): ");
            playAgain = scanner.next();
        }
        scanner.close();
    }
}
