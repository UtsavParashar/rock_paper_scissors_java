package com.rps.game;

import java.util.Scanner;

public class PlayerFactory {

    public static Player createPlayer(String type, String name, Scanner scanner) {
        return switch (type.toLowerCase()) {
            case "human" -> new HumanPlayer(name, scanner);
            case "computer" -> new ComputerPlayer(name, new RandomMoveStrategy());
            default -> throw new IllegalArgumentException("Invalid player type: " + type);
        };
    }
}
