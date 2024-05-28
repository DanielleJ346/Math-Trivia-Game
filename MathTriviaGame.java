import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class MathTriviaGame {
    public static void main(String[] args) {
        System.out.println("Welcome to the Edureka Trivia Game!"); // Welcome message
        TreeSet<Integer> correctAnswers = new TreeSet<>(); // Create a TreeSet to store correct answers
        Scanner scanner = new Scanner(System.in); // Create a Scanner object to read user input
        Random random = new Random(); // Random number generator
        
        // Main game loop
        while (true) {
            // Generate two random numbers between 1 and 10
            int num1 = random.nextInt(10) + 1;
            int num2 = random.nextInt(10) + 1;
            char operator = getRandomOperator(); // Randomly select an operator (+, -, *)
            
            // Calculate the correct answer to the math problem
            int correctAnswer = calculateAnswer(num1, num2, operator);

            // Display the math problem to the user
            System.out.print("What is " + num1 + " " + operator + " " + num2 + "? ");
            
            /* Check if the user's  answer is invalid*/
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.next();
                continue;
            }

            int userAnswer = scanner.nextInt();

            // Check if the user wants to exit
            if (userAnswer == 999) {
                break;
            }
            
            // If the answer is correct, add it to the TreeSet
            if (userAnswer == correctAnswer) {
                correctAnswers.add(correctAnswer);
                System.out.println("Welldone, that's correct!");
            } else {
                System.out.println("Wrong Answer, the correct answer is: " + correctAnswer);
            }
        }
        
        // Print the contents of the TreeSet
        System.out.println("Thank you for playing!");
        System.out.println("Correct answers in Treeset");
        for (int answer : correctAnswers) {
            System.out.println(answer);
        }
        
        // Close the Scanner
        scanner.close();
    }
    
    // Method to randomly select an operator
    public static char getRandomOperator() {
        char[] operators = {'+', '-', '*'};
        Random random = new Random();
        return operators[random.nextInt(operators.length)];
    }
    
    // Method to check if the user's answer is correct
    public static int calculateAnswer(int num1, int num2, char operator) {
        int correctAnswer;
        switch (operator) {
            case '+':
                correctAnswer = num1 + num2;
                break;
            case '-':
                correctAnswer = num1 - num2;
                break;
            case '*':
                correctAnswer = num1 * num2;
                break;
            default:
                correctAnswer = 0; // Invalid operator
        }
        return correctAnswer;
    }
}
