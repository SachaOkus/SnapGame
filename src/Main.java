public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Alice");
        Player player2 = new Player("Bob");

        Snap snapGame = new Snap("Snap Game");
        snapGame.shuffleDeck();
        snapGame.playSnap();
    }
}
