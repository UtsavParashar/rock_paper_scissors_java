package com.rps.game;

import java.util.List;

public class Game {
    private final List<Player> players;
    private final RulesEngine rulesEngine;

    public Game(List<Player> players, RulesEngine rulesEngine) {
        if (players == null || players.size() != 2) {
            throw new IllegalArgumentException("Game requires exactly two players.");
        }
        this.players = players;
        this.rulesEngine = rulesEngine;
    }

    public GameResult playRound() {
        Move move1 = players.get(0).getMove();
        Move move2 = players.get(1).getMove();

        System.out.println(move1);
        System.out.println(move2);

        return rulesEngine.determineWinner(move1, move2);
    }
}
