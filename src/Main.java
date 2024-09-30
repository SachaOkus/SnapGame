public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");

        Snap snapGame = new Snap("Snap Game", player1, player2);
        snapGame.shuffleDeck();
        snapGame.playSnap();
    }
}
