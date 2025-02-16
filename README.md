# Rock Paper Scissors Game

A production-level Java implementation of the Rock-Paper-Scissors game for an human to play against Computer which choose its moves randomly. 
For better user engagement Computer could follow strategies like Markov, Reinforcement learning and Game Theory. I have used few of these strategies in my attached Rock Paper Scissors Python project.

## Features and Business Logic

*   **Classic Gameplay:** Emulates the traditional Rock Paper Scissors rules.
*   **Human vs. Computer:** Play against an Computer Player opponent.
*   **Configurable Rounds:** Determine the number of rounds to play at the start of the game.
*   **Automated Simulation:** Simulate games for testing or demonstration purposes.
*   **Score Tracking:** Displays the final score, including wins, losses, and ties.
*   **Input Flexibility**: Ability to enter moves as text or number

## Technical Design

### Modular Architecture

The application is designed with a modular architecture to promote maintainability and extensibility:

*   **`Game.java`:** Orchestrates a single round of the Rock Paper Scissors game between two players.
*   **`GameResult.java` (Record):**  A simple data carrier holding the outcome of a game round (winner and message).
*   **`Player.java` (Interface):** Defines the contract for any player in the game (human or computer).
*   **`Move.java` (Record):** Represents a player's move, containing the move type and the player making the move.
*   **`MoveType.java` (Enum):** Enumerates the possible moves in the game: Rock, Paper, Scissors.
*   **`ComputerPlayer.java`:** An implementation of the `Player` interface representing the computer opponent, using a `MoveStrategy`.
*   **`HumanPlayer.java`:**  An implementation of the `Player` interface representing the human player, taking input from the console.
*   **`PlayerFactory.java`:**  A factory class responsible for creating `Player` instances (human or computer) based on configuration.
*   **`RulesEngine.java`:**  Encapsulates the rules of the game and determines the winner of each round.
*   **`RandomMoveStrategy.java`:** A `MoveStrategy` implementation that makes a random move.
*   **`MoveStrategy.java` (Interface):**  Defines the strategy for a `ComputerPlayer` to select a move.
*   **`Play.java`:**  The main class that drives the game, handling user interaction, game loop, and score tracking.
*    **`Simulate.java`**: Simulates game play for the human player for testing or demonstration purposes.
### Design Patterns

*   **Strategy Pattern:** The `MoveStrategy` interface and its implementations (`RandomMoveStrategy`) exemplify the Strategy pattern, allowing for different Computer player behaviors to be easily swapped.
*   **Factory Pattern:** The `PlayerFactory` class implements the Factory pattern, centralizing the creation of `Player` objects and decoupling the client code from the concrete player classes.

### Comprehensive Unit Testing

The project includes a suite of unit tests that cover critical components and functionalities. Each module has corresponding tests that validate its behavior, ensuring code reliability and reducing the likelihood of bugs.

## Dependencies

*   **JUnit 5:** Used for writing and running unit tests.
*   **Mockito:** Used for creating mock objects to isolate components during testing.

## Setup Instructions

1.  **Navigate to the project directory:** `cd rock_paper_scissors_java`
2.  **Build the project using Maven:** `mvn clean install`
3.  **Run the game:** `mvn exec:java -Dexec.mainClass="com.rps.game.Play"`

## Testing

*   **Run unit tests:** Execute `mvn test` to run the JUnit tests and verify the functionality of individual components.


## Simulator

*   **Run the simulator:** Execute "com.rps.game.Simulate" to simulate a game on behalf of the human player. The simulator will prompt you for the number of rounds to simulate. This is useful for testing game behavior and collecting statistics without manual input.

## Future Enhancements

*   Implement a graphical user interface (GUI) using JavaFX or Swing.
*   Add more sophisticated strategies, such as machine learning-based opponents.
*   Implement a scoring system to track game statistics over multiple sessions.
*   Allow players to customize their names and avatars.
*   Implement network play to allow players to compete against each other online.
*   Extend the game to support additional moves (e.g., Rock Paper Scissors Lizard Spock).

