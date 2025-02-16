package com.rps.game;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private final Random random = new Random();

    @Override
    public MoveType getMove() {
        MoveType[] moves = MoveType.values();
        return moves[random.nextInt(moves.length)];
    }
}
