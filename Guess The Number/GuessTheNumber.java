import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int attempts = 0;
        int score = 0;
        boolean playAgain = true;

        System.out.println("Welcome to Guess the Number!");

        while (playAgain) {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("I have selected a number between " + minRange + " and " + maxRange);
            
            int guess;
            boolean guessedCorrectly = false;
            
            while (!guessedCorrectly) {
                System.out.print("Enter your Guess: ");
                guess = scanner.nextInt();
                attempts++;

                if (guess == randomNumber) {
                    System.out.println("Congratulations!!! You Have Guessed the correct number in " + attempts + " attempts.");
                    score += (maxRange - minRange + 1) - attempts; // Higher score for fewer attempts
                    guessedCorrectly = true;
                } else if (guess < randomNumber) {
                    System.out.println("The number is Higher.");
                } else {
                    System.out.println("The number is Lower.");
                }
            }

            System.out.println("Your score: " + score);
            System.out.print("Do you want to play again? (Yes/No): ");
            String playAgainResponse = scanner.next();
            
            if (!playAgainResponse.equalsIgnoreCase("Yes")) {
                playAgain = false;
            } else {
                attempts = 0;
            }
        }
        
        System.out.println("Thank you for playing Guess the Number!!!");
        scanner.close();
    }
}
