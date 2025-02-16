// Play.java
package com.rps.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Play {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Rock Paper Scissors!");

        // Player setup
        Player humanPlayer = PlayerFactory.createPlayer("human", "You", scanner);
        Player computerPlayer = PlayerFactory.createPlayer("computer", "Computer", scanner);
        List<Player> players = new ArrayList<>();
        players.add(humanPlayer);
        players.add(computerPlayer);

        RulesEngine rulesEngine = new RulesEngine(); // Create a RulesEngine instance
        Game game = new Game(players, rulesEngine); // Pass the rulesEngine to the Game constructor


        // Get number of rounds from user
        int numRounds = getNumberOfRounds(scanner);

        // Game loop
        int round = 0;
        int humanWins = 0;
        int computerWins = 0;
        int ties = 0;

        while (round < numRounds) {
            round++;
            System.out.println("\nRound " + round + " of " + numRounds);

            // Get human player's move
            Move humanMove = getHumanMove(scanner, humanPlayer);
            if (humanMove == null) {
                break; // Exit if user chooses to exit
            }

            // Get computer player's move
            Move computerMove = computerPlayer.getMove();

            System.out.println(humanMove);
            System.out.println(computerMove);

            GameResult result = rulesEngine.determineWinner(humanMove, computerMove);


            if (result.winner() == humanPlayer) {
                System.out.println(result.message());
                humanWins++;
            } else if (result.winner() == computerPlayer) {
                System.out.println(result.message());
                computerWins++;
            } else {
                System.out.println(result.message());
                ties++;
            }
        }

        // Final score
        System.out.println("\n--- Final Score ---");
        System.out.println("Rounds Played: " + round);
        System.out.println("Your Wins: " + humanWins);
        System.out.println("Computer Wins: " + computerWins);
        System.out.println("Ties: " + ties);

        System.out.println("\nThanks for playing!");
        scanner.close();
    }

    private static int getNumberOfRounds(Scanner scanner) {
        int numRounds;
        while (true) {
            System.out.print("Enter the number of rounds you want to play: ");
            try {
                numRounds = Integer.parseInt(scanner.nextLine().trim());
                if (numRounds > 0) {
                    break;
                } else {
                    System.out.println("Please enter a positive number of rounds.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        return numRounds;
    }

    private static Move getHumanMove(Scanner scanner, Player humanPlayer) {
        while (true) {
            System.out.print("Enter your move (1 for Rock, 2 for Paper, 3 for Scissors, 0 to Exit): ");
            String input = scanner.nextLine().trim();

            switch (input) {
                case "1", "rock" -> {
                    return new Move(MoveType.ROCK, humanPlayer);
                }
                case "2", "paper" -> {
                    return new Move(MoveType.PAPER, humanPlayer);
                }
                case "3", "scissors" -> {
                    return new Move(MoveType.SCISSORS, humanPlayer);
                }
                case "0" -> {
                    return null; // Indicates exit
                }
                default -> {
                    System.out.println("Invalid input. Please enter 1, 2, 3, or 0.");
                }
            }
        }
    }
}
