package com.rps.game;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class GameTest {

    @Test
    void testGameRequiresTwoPlayers() {
        Player player1 = Mockito.mock(Player.class);
        List<Player> players = Arrays.asList(player1);
        RulesEngine rulesEngine = new RulesEngine();

        assertThrows(IllegalArgumentException.class, () -> new Game(players, rulesEngine));
    }

    @Test
    void testPlayRoundRockBeatsScissors() {
        Player player1 = Mockito.mock(Player.class);
        Player player2 = Mockito.mock(Player.class);

        when(player1.getName()).thenReturn("Player 1");
        when(player2.getName()).thenReturn("Player 2");
        when(player1.getMove()).thenReturn(new Move(MoveType.ROCK, player1));
        when(player2.getMove()).thenReturn(new Move(MoveType.SCISSORS, player2));

        List<Player> players = Arrays.asList(player1, player2);
        RulesEngine rulesEngine = new RulesEngine();
        Game game = new Game(players, rulesEngine);

        GameResult result = game.playRound();
        assertEquals(player1, result.winner());
    }
}
