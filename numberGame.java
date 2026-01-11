import java.util.Random;
import java.util.Scanner;

public class numberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {
            int lowerBound = 1;
            int upperBound = 100;
            int secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            int maxAttempts = 10; // Limit the number of attempts
            boolean guessedCorrectly = false;

            System.out.println("Welcome to the Number Game!");
            System.out.println("Guess a number between " + lowerBound + " and " + upperBound + ".");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                if (scanner.hasNextInt()) {
                    int userGuess = scanner.nextInt();
                    attempts++;

                    if (userGuess == secretNumber) {
                        System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                        guessedCorrectly = true;
                        break;
                    } else if (userGuess < secretNumber) {
                        System.out.println("Too low. Try again.");
                    } else {
                        System.out.println("Too high. Try again.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter an integer.");
                    scanner.next(); // Consume the invalid input
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you ran out of attempts. The secret number was " + secretNumber + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        scanner.close();
        System.out.println("Thanks for playing!");
    }
}