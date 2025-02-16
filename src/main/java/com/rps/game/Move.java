package com.rps.game;

public record Move(MoveType type, Player player) {
    @Override
    public String toString() {
        return player.getName() + " chose " + type.toString();
    }
}
