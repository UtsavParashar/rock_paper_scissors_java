package com.rps.game;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class ComputerPlayerTest {

    @Test
    void testComputerPlayerAlwaysReturnsAValidMove() {
        MoveStrategy mockStrategy = Mockito.mock(MoveStrategy.class);
        when(mockStrategy.getMove()).thenReturn(MoveType.ROCK);

        ComputerPlayer computerPlayer = new ComputerPlayer("TestComputer", mockStrategy);
        Move move = computerPlayer.getMove();

        assertNotNull(move);
    }
}
