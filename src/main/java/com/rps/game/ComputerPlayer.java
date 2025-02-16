package com.rps.game;

public class ComputerPlayer implements Player {
    private final String name;
    private final MoveStrategy moveStrategy;

    public ComputerPlayer(String name, MoveStrategy moveStrategy) {
        this.name = name;
        this.moveStrategy = moveStrategy;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Move getMove() {
        MoveType moveType = moveStrategy.getMove();
        return new Move(moveType, this);
    }
}
