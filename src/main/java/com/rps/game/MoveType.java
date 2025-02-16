package com.rps.game;

public enum MoveType {
    ROCK, PAPER, SCISSORS;

    public static MoveType fromString(String input) {
        return switch (input.toUpperCase()) {
            case "ROCK", "R" -> ROCK;
            case "PAPER", "P" -> PAPER;
            case "SCISSORS", "S" -> SCISSORS;
            default -> throw new IllegalArgumentException("Invalid move: " + input);
        };
    }
}
