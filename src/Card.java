public class Card {
    private final String suit;    // Suit: ♥, ♣, ♦, ♠
    private final String symbol;  // Symbol: 2-10, J, Q, K, A
    private final int value;      // Value: 2-14

    public Card(String suit, String symbol, int value) {
        this.suit = suit;
        this.symbol = symbol;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return symbol + " of " + suit;
    }
}
