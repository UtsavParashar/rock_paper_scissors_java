package com.rps.game;

import java.util.Scanner;

public class HumanPlayer implements Player {
    private final String name;
    private final Scanner scanner;

    public HumanPlayer(String name, Scanner scanner) {
        this.name = name;
        this.scanner = scanner;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Move getMove() {
        while (true) {
            System.out.printf("%s, enter your move (Rock/Paper/Scissors): ", name);
            String input = scanner.nextLine().trim();
            try {
                MoveType moveType = MoveType.fromString(input);
                return new Move(moveType, this);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                // Prompt again
            }
        }
    }
}
