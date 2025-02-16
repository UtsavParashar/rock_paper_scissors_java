package com.rps.game;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class RulesEngineTest {

    @Test
    void testRockBeatsScissors() {
        Player player1 = Mockito.mock(Player.class);
        Player player2 = Mockito.mock(Player.class);
        Mockito.when(player1.getName()).thenReturn("Player 1");
        Move rockMove = new Move(MoveType.ROCK, player1);
        Move scissorsMove = new Move(MoveType.SCISSORS, player2);

        RulesEngine rulesEngine = new RulesEngine();
        GameResult result = rulesEngine.determineWinner(rockMove, scissorsMove);

        assertEquals(player1, result.winner());
    }

    @Test
    void testPaperBeatsRock() {
        Player player1 = Mockito.mock(Player.class);
        Player player2 = Mockito.mock(Player.class);
        Mockito.when(player1.getName()).thenReturn("Player 1");
        Move paperMove = new Move(MoveType.PAPER, player1);
        Move rockMove = new Move(MoveType.ROCK, player2);

        RulesEngine rulesEngine = new RulesEngine();
        GameResult result = rulesEngine.determineWinner(paperMove, rockMove);

        assertEquals(player1, result.winner());
    }

    @Test
    void testScissorsBeatsPaper() {
        Player player1 = Mockito.mock(Player.class);
        Player player2 = Mockito.mock(Player.class);
        Mockito.when(player1.getName()).thenReturn("Player 1");
        Move scissorsMove = new Move(MoveType.SCISSORS, player1);
        Move paperMove = new Move(MoveType.PAPER, player2);

        RulesEngine rulesEngine = new RulesEngine();
        GameResult result = rulesEngine.determineWinner(scissorsMove, paperMove);

        assertEquals(player1, result.winner());
    }

    @Test
    void testTie() {
        Player player1 = Mockito.mock(Player.class);
        Mockito.when(player1.getName()).thenReturn("Player 1");
        Move rockMove1 = new Move(MoveType.ROCK, player1);
        Move rockMove2 = new Move(MoveType.ROCK, player1);

        RulesEngine rulesEngine = new RulesEngine();
        GameResult result = rulesEngine.determineWinner(rockMove1, rockMove2);

        assertNull(result.winner());
        assertEquals("It's a tie!", result.message());
    }
}
