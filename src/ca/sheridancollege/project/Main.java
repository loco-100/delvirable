 /**
 * SYST 17796 Project Base code.
 * Main class for running the War Game.
 * @author Rajanpreet Kaur
 * 14-11-2024
 */
package ca.sheridancollege.project;

public class Main {
    public static void main(String[] args) {
        Game warGame = new WarGame("War Game");
        
        // Create players
        Player player1 = new WarPlayer("Player 1");
        Player player2 = new WarPlayer("Player 2");

        // Add players to the game
        warGame.getPlayers().add(player1);
        warGame.getPlayers().add(player2);

        // Start the game
        warGame.play();

        // Declare the winner
        warGame.declareWinner();
    }
}