import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Snap extends CardGame {

    public Snap(String name) {
        super(name);
    }

    public void playSnap() {
        Scanner scanner = new Scanner(System.in);
        Card previousCard = null;

        while (deckOfCards.size() > 0) {
            System.out.println("Press Enter to deal a card...");
            scanner.nextLine();
            Card currentCard = dealCard();
            System.out.println("Card dealt: " + currentCard);

            if (previousCard != null && currentCard.getSymbol().equals(previousCard.getSymbol())) {
                System.out.println("Snap opportunity! Type 'snap' within 2 seconds to win.");

                boolean snapResult = waitForSnap(scanner);
                if (snapResult) {
                    System.out.println("Snap! You win!");
                } else {
                    System.out.println("Too slow! You lose.");
                }
                break;
            }
            previousCard = currentCard;
        }

        if (deckOfCards.size() == 0) {
            System.out.println("Game Over! No more cards in the deck.");
        }
        scanner.close();
    }

    private boolean waitForSnap(Scanner scanner) {
        final boolean[] snapSuccess = {false};

        // Create a new Timer that counts down from 2 seconds
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (!snapSuccess[0]) {
                    System.out.println("Time's up! You failed to type 'snap' in time.");
                }
            }
        };

        // Schedule the task to run after 2 seconds (2000 milliseconds)
        timer.schedule(task, 2000);

        // Wait for the player's input
        String input = scanner.nextLine();

        // If the player types "snap" before the timer finishes
        if (input.equalsIgnoreCase("snap")) {
            snapSuccess[0] = true;
            timer.cancel();  // Cancel the timer since the player succeeded
            return true;
        }

        return false;
    }
}
