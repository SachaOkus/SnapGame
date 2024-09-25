import java.util.Scanner;

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
                System.out.println("Snap! You win!");
                break;
            }
            previousCard = currentCard;
        }

        if (deckOfCards.size() == 0) {
            System.out.println("Game Over! No more cards in the deck.");
        }
        scanner.close();
    }
}
