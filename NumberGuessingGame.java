import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int totalRounds = 0;
        int totalScore = 0;
        boolean playAgain = true;

        while (playAgain) {
          
            int targetNumber = random.nextInt(100) + 1;
            int maxAttempts = 10;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have generated a random number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it correctly.");

           
            while (attempts < maxAttempts && !guessedCorrectly) {
                attempts++;
                System.out.print("Attempt " + attempts + ": Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess < targetNumber) {
                    System.out.println("Your guess is too low. Try again!");
                } else if (userGuess > targetNumber) {
                    System.out.println("Your guess is too high. Try again!");
                } else {
                    guessedCorrectly = true;
                    System.out.println("Congratulations! You've guessed the correct number.");
                }
            }

           
            if (!guessedCorrectly) {
                System.out.println("Sorry! You've run out of attempts. The correct number was " + targetNumber);
            }

            
            int score = (guessedCorrectly) ? (maxAttempts - attempts + 1) : 0;
            totalScore += score;
            totalRounds++;

            
            System.out.println("Your score for this round: " + score);
            System.out.println("Total Score: " + totalScore);
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();

            if (response.equalsIgnoreCase("no")) {
                playAgain = false;
                System.out.println("Thanks for playing! Total rounds played: " + totalRounds);
                System.out.println("Final score: " + totalScore);
            }
        }

        scanner.close();
    }
}
