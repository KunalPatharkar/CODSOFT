import java.util.Random;
public class GuessingGame {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    private static final int MAX_ATTEMPTS = 10;
    public static void main(String[] args) {
        int number = new Random().nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
        int attempts = 0;
        int guess;
        do {
            guess = getGuess();
            if (guess == number) {
                System.out.println("Congratulations! You guessed the number correctly.");
                break;
            } else if (guess < number) {
                System.out.println("Your guess is too low.");
            } else {
                System.out.println("Your guess is too high.");
            }
            attempts++;
        } while (attempts < MAX_ATTEMPTS);

        if (attempts == MAX_ATTEMPTS) {
            System.out.println("You have run out of attempts. The number was " + number);
        } else {
            System.out.println("You guessed the number in " + attempts + " attempts.");
        }
    }
    private static int getGuess() {
        System.out.print("Enter your guess: ");
        int guess = Integer.parseInt(System.console().readLine());
        return guess;
    }
}
