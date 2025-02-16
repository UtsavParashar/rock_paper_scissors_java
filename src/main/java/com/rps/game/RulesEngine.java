package com.rps.game;

public class RulesEngine {

    private static final String WINS_MESSAGE = " wins the round!";
    private static final String WON_MESSAGE = " won!";

    public GameResult determineWinner(Move move1, Move move2) {
        MoveType type1 = move1.type();
        MoveType type2 = move2.type();

        if (type1 == type2) {
            return new GameResult(null, "It's a tie!");
        }

        return switch (type1) {
            case ROCK -> (type2 == MoveType.SCISSORS) ? new GameResult(move1.player(), move1.player().getName() + WON_MESSAGE) : new GameResult(move2.player(), move2.player().getName() + WINS_MESSAGE);
            case PAPER -> (type2 == MoveType.ROCK) ? new GameResult(move1.player(), move1.player().getName() + WON_MESSAGE) : new GameResult(move2.player(), move2.player().getName() + WINS_MESSAGE);
            case SCISSORS -> (type2 == MoveType.PAPER) ? new GameResult(move1.player(), move1.player().getName() + WON_MESSAGE) : new GameResult(move2.player(), move2.player().getName() + WINS_MESSAGE);
        };
    }
}
