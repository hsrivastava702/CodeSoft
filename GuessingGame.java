import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int maxRange = 100;
        int maxAttempts = 5;
        int totalScore = 0;
        int rounds = 0;
        
        boolean playAgain = true;
        
        while (playAgain) {
            System.out.println("Round " + (rounds + 1));
            int secretNumber = random.nextInt(maxRange) + 1;
            int attempts = 0;
            
            while (attempts < maxAttempts) {
                System.out.print("Guess the number (between 1 and 100): ");
                int guess = scanner.nextInt();
                attempts++;
                
                if (guess == secretNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts!");
                    totalScore++;
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
                
                if (attempts == maxAttempts) {
                    System.out.println("You've reached the maximum number of attempts. The correct number was: " + secretNumber);
                }
            }
            
            rounds++;
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();
            if (!playAgainInput.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }
        
        System.out.println("Game over! You played " + rounds + " round(s) and scored " + totalScore + " point(s).");
        scanner.close();
    }
}
