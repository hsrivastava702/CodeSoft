import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Quiz {
    private static final int NUM_QUESTIONS = 5;
    private static final int[] TIME_LIMITS = {30, 60, 45, 30, 60}; // time limits in seconds
    private static final String[][] QUESTIONS = {
            {"What is the capital of France? ", "A. London", "B. Berlin", "C. Paris", "D. Madrid"},
            {"Who wrote the novel 'Pride and Prejudice'? ", "A. Charles Dickens", "B. Jane Austen", "C. Mark Twain", "D. Ernest Hemingway"},
            {"What is the largest planet in our solar system? ", "A. Earth", "B. Mars", "C. Jupiter", "D. Saturn"},
            {"Which of these programming languages is not object-oriented? ", "A. Java", "B. C++", "C. Python", "D. HTML"},
            {"What is the square root of 64? ", "A. 6", "B. 7", "C. 8", "D. 9"}
    };
    private static final int[] ANSWERS = {2, 1, 3, 4, 3}; // correct answers (0-based index)

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (int i = 0; i < NUM_QUESTIONS; i++) {
            System.out.println("Question " + (i+1) + ":");
            displayQuestion(QUESTIONS[i]);
            int timeLimit = TIME_LIMITS[i];
            final int currentIndex = i; // Capture the current index in a final variable
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Time's up! The correct answer is " + QUESTIONS[currentIndex][ANSWERS[currentIndex]]);
                    scanner.nextLine(); // consume input to avoid blocking
                }
            }, timeLimit * 1000);
            int userAnswer = scanner.nextInt();
            timer.cancel();
            if (userAnswer == ANSWERS[i]) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect. The correct answer is " + QUESTIONS[i][ANSWERS[i]]);
            }
        }

        System.out.println("Result:");
        System.out.println("You got " + score + " out of " + NUM_QUESTIONS + " questions correct!");
        scanner.close();
    }

    private static void displayQuestion(String[] question) {
        for (int i = 0; i < question.length; i++) {
            System.out.printf("%s%n", question[i]);
        }
    }
}
