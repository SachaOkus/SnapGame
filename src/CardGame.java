import java.util.ArrayList;
import java.util.Collections;

public class CardGame {
    protected ArrayList<Card> deckOfCards;

    public CardGame(String name) {
        deckOfCards = new ArrayList<>();
        initialiseDeck();
    }

    private void initialiseDeck() {
        String[] suits = {"♥", "♣", "♦", "♠"};
        String[] symbols = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

        for (String suit : suits) {
            for (int i = 0; i < symbols.length; i++) {
                deckOfCards.add(new Card(suit, symbols[i], values[i]));
            }
        }
    }

    public ArrayList<Card> getDeck() {
        return deckOfCards;
    }

    public void shuffleDeck() {
        Collections.shuffle(deckOfCards);
    }

    public Card dealCard() {
        if (deckOfCards.size() > 0) {
            return deckOfCards.remove(0);
        }
        return null;
    }

    public void sortDeckInNumberOrder() {
        deckOfCards.sort((Card c1, Card c2) -> Integer.compare(c1.getValue(), c2.getValue()));
    }

    public void sortDeckIntoSuits() {
        deckOfCards.sort((Card c1, Card c2) -> {
            int suitComparison = c1.getSuit().compareTo(c2.getSuit());
            if (suitComparison != 0) {
                return suitComparison;
            } else {
                return Integer.compare(c1.getValue(), c2.getValue());
            }
        });
    }

    public void displayDeck() {
        for (Card card : deckOfCards) {
            System.out.println(card);
        }
    }
}