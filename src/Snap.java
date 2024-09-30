import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Snap extends CardGame {

    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public Snap(String name, Player player1, Player player2) {
        super(name);
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;  // Player 1 starts first
    }

    public void playSnap() {
        Scanner scanner = new Scanner(System.in);
        Card previousCard = null;

        while (deckOfCards.size() > 0) {
            System.out.println(currentPlayer.getName() + "'s turn. Press Enter to deal a card...");
            scanner.nextLine();  // Wait for the current player to press Enter to deal a card

            Card currentCard = dealCard();
            System.out.println("Card dealt: " + currentCard);

            // Check if it's a snap opportunity (two consecutive cards with the same symbol)
            if (previousCard != null && currentCard.getSymbol().equals(previousCard.getSymbol())) {
                System.out.println("Snap opportunity for " + currentPlayer.getName() + "! Type 'snap' within 2 seconds to win or press Enter to continue.");

                boolean snapResult = waitForSnap(scanner);
                if (snapResult) {
                    System.out.println("Snap! " + currentPlayer.getName() + " wins!");
                    break;
                } else {
                    System.out.println("No snap! Continuing the game...");
                }
            }

            // Set the previous card for the next iteration
            previousCard = currentCard;

            // Alternate the player for the next turn
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }

        // If no more cards are available in the deck
        if (deckOfCards.size() == 0) {
            System.out.println("Game Over! No more cards in the deck.");
        }

        // Close the scanner to avoid resource leaks
        scanner.close();
    }

    private boolean waitForSnap(Scanner scanner) {
        final boolean[] snapSuccess = {false};

        // Create a new Timer that counts down from 2 seconds
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // If no snap is entered within the time limit, notify the player
                if (!snapSuccess[0]) {
                    System.out.println("Time's up! " + currentPlayer.getName() + " didn't type 'snap' in time.");
                }
            }
        };

        // Schedule the task to run after 2 seconds (2000 milliseconds)
        timer.schedule(task, 2000);

        // Wait for the player's input
        String input = scanner.nextLine();

        // If the player types "snap" within 2 seconds
        if (input.equalsIgnoreCase("snap")) {
            snapSuccess[0] = true;
            timer.cancel();  // Cancel the timer since the player succeeded
            return true;
        }

        // If the player presses Enter or doesn't type "snap", the game continues
        return false;
    }
}
