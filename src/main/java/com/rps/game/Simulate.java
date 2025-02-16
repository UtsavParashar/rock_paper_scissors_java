// Simulate.java
package com.rps.game;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Simulate {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Get number of rounds to simulate
        System.out.print("Enter the number of rounds to simulate: ");
        int numRounds = scanner.nextInt();

        Player humanPlayer = new HumanPlayer("Simulated Player", scanner);
        Player computerPlayer = new ComputerPlayer("Computer", new RandomMoveStrategy());
        RulesEngine rulesEngine = new RulesEngine();
        Game game = new Game(List.of(humanPlayer, computerPlayer), rulesEngine);

        int humanWins = 0;
        int computerWins = 0;
        int ties = 0;

        for (int round = 1; round <= numRounds; round++) {
            System.out.println("\nRound " + round + " of " + numRounds);

            // Simulate human player's move randomly
            MoveType simulatedMoveType = MoveType.values()[random.nextInt(MoveType.values().length)];
            Move humanMove = new Move(simulatedMoveType, humanPlayer);
            Move computerMove = computerPlayer.getMove();

            System.out.println("Simulated Player chose: " + simulatedMoveType);
            System.out.println("Computer chose: " + computerMove.type());

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
        System.out.println("Simulated Player Wins: " + humanWins);
        System.out.println("Computer Wins: " + computerWins);
        System.out.println("Ties: " + ties);

        scanner.close();
    }
}
