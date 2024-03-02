import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Game {
    private int[] board;
    private int numPlayers;
    Player[] players;
    private int currentPlayerIndex;

    public Game(int numPlayers, String[] playerNames) {
        this.numPlayers = numPlayers;
        this.board = new int[100];
        this.players = new Player[numPlayers];
        initializeBoard();
        initializePlayers(playerNames);
        this.currentPlayerIndex = 0;
    }

    private void initializeBoard() {
        // Ladders: Format -> board[start_position] = number_of_steps_to_climb
        board[9] = 21;
        board[25] = 19;
        board[41] = 21;
        board[74] = 21;

        // Snakes: Format -> board[start_position] = number_of_steps_to_slide
        board[37] = -19;
        board[70] = -16;
        board[65] = -29;
        board[81] = -4;
    }

    private void initializePlayers(String[] playerNames) {
        for (int i = 0; i < numPlayers; i++) {
            players[i] = new Player(playerNames[i]);
        }
    }

    public int rollDice() {
        return (int) (Math.random() * 6) + 1;
    }

    public int movePlayer(Player player, int steps) {
        synchronized (this) {
            int currentPosition = player.getPosition();
            int newPosition = currentPosition + steps;

            if (newPosition >= 100) {
                System.out.println(player.getPlayerName() + " wins!");
                System.exit(0);
            }

            if (board[newPosition] != 0) {
                newPosition += board[newPosition];
                if (currentPosition > newPosition) {
                    System.out.println(player.getPlayerName() + " encounters a snake and moves to position " + newPosition);
                } else {
                    System.out.println(player.getPlayerName() + " encounters a ladder and moves to position " + newPosition);
                }
            }

            player.setPosition(newPosition);
            return newPosition;
        }
    }

    public synchronized void playGame() {
        while (true) {
            Player currentPlayer = players[currentPlayerIndex];
            currentPlayer.takeTurn(); // Let the player take their turn

            currentPlayerIndex = (currentPlayerIndex + 1) % numPlayers;

            try {
                wait(1000); // Wait for 1 second 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Player extends Thread {
    private String name;
    private int position;
    private Game game;

    public Player(String name) {
        this.name = name;
        this.position = 0;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getPlayerName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void takeTurn() {
        int steps;
        do {
            steps = game.rollDice();
            int newPosition = game.movePlayer(this, steps);
            System.out
                    .println(getPlayerName() + " rolled a " + steps + " and is now at position " + newPosition + "\n");
            if (steps == 6) {
                System.out.println(getPlayerName() + " rolled 6 so he will roll the dice again!!");
            }
        } while (steps == 6);
    }

    @Override
    public void run() {
        while (true) {
            synchronized (game) {
                // Wait for the game manager to signal the player to take a turn
                try {
                    game.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Player takes a turn
                takeTurn();

                // Notify the game manager that the turn is done
                game.notify();
            }
        }
    }
}

class SnakesAndLaddersGame {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the number of players: ");
        int numPlayers = Integer.parseInt(reader.readLine());

        String[] playerNames = new String[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter the name of Player " + (i + 1) + ": ");
            playerNames[i] = reader.readLine();
        }

        Game game = new Game(numPlayers, playerNames);

        // Set the game for each player and start their threads
        for (Player player : game.players) {
            player.setGame(game);
            player.start();
        }

        game.playGame(); // Start the game
    }
}
