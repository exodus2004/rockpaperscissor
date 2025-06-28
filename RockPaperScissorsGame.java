package rockpaperscissor;

import java.util.*;

public class RockPaperScissorsGame {
    private static final String[] CHOICES = {"rock", "paper", "scissors"};
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    
    private static int userWins = 0;
    private static int computerWins = 0;
    private static int ties = 0;
    
    public static void main(String[] args) {
        System.out.println("=== Welcome to Rock Paper Scissors ===");
        
        do {
            playRound();
            displayScore();
        } while (playAgain());
        
        displayFinalResults();
        scanner.close();
    }
    
    private static void playRound() {
        String userChoice = getUserChoice();
        String computerChoice = getComputerChoice();
        
        System.out.println("\nYour choice: " + userChoice);
        System.out.println("Computer choice: " + computerChoice);
        
        GameResult result = determineWinner(userChoice, computerChoice);
        displayResult(result);
        updateScore(result);
    }
    
    private static String getUserChoice() {
        String choice;
        while (true) {
            System.out.print("\nEnter your choice (rock/paper/scissors): ");
            choice = scanner.nextLine().toLowerCase().trim();
            
            if (isValidChoice(choice)) {
                return choice;
            }
            
            System.out.println("Invalid choice! Please enter rock, paper, or scissors.");
        }
    }
    
    private static boolean isValidChoice(String choice) {
        return Arrays.asList(CHOICES).contains(choice);
    }
    
    private static String getComputerChoice() {
        return CHOICES[random.nextInt(CHOICES.length)];
    }
    
    private static GameResult determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return GameResult.TIE;
        }
        
        boolean userWins = (userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                          (userChoice.equals("paper") && computerChoice.equals("rock")) ||
                          (userChoice.equals("scissors") && computerChoice.equals("paper"));
        
        return userWins ? GameResult.USER_WIN : GameResult.COMPUTER_WIN;
    }
    
    private static void displayResult(GameResult result) {
        switch (result) {
            case TIE:
                System.out.println("It's a tie!");
                break;
            case USER_WIN:
                System.out.println("You won this round!");
                break;
            case COMPUTER_WIN:
                System.out.println("Computer won this round!");
                break;
        }
    }
    
    private static void updateScore(GameResult result) {
        switch (result) {
            case TIE:
                ties++;
                break;
            case USER_WIN:
                userWins++;
                break;
            case COMPUTER_WIN:
                computerWins++;
                break;
        }
    }
    
    private static void displayScore() {
        System.out.println("\n--- Current Score ---");
        System.out.println("You: " + userWins);
        System.out.println("Computer: " + computerWins);
        System.out.println("Ties: " + ties);
    }
    
    private static boolean playAgain() {
        while (true) {
            System.out.print("\nWould you like to play again? (yes/no): ");
            String response = scanner.nextLine().toLowerCase().trim();
            
            if (response.equals("yes") || response.equals("y")) {
                return true;
            } else if (response.equals("no") || response.equals("n")) {
                return false;
            } else {
                System.out.println("Please enter 'yes' or 'no'.");
            }
        }
    }
    
    private static void displayFinalResults() {
        System.out.println("\n=== Final Results ===");
        displayScore();
        
        if (userWins > computerWins) {
            System.out.println("Congratulations! You won overall!");
        } else if (computerWins > userWins) {
            System.out.println("Computer won overall. Better luck next time!");
        } else {
            System.out.println("It's a tie overall! Great game!");
        }
        
        System.out.println("Thanks for playing!");
    }
    
    private enum GameResult {
        TIE, USER_WIN, COMPUTER_WIN
    }
}

