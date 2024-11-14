  /**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Author: Rajanpreet Kaur
 * Date: 2024-10-09
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

public class Game {

    private final String name; // the title of the game
    private final ArrayList<Player> players; // the players of the game

    public Game(String name) {
        this.name = name;
        players = new ArrayList<>();
    }

    // Getter for the game name
    public String getName() {
        return name;
    }

    // Getter for players
    public ArrayList<Player> getPlayers() {
        return players;
    }

    // Method to add a player to the game
    public void addPlayer(Player player) {
        players.add(player);
    }

    // Play the game
    public void play() {
        System.out.println("Starting the game: " + name);
        for (Player player : players) {
            player.play();
        }
    }

    // Declare a winner (placeholder for game logic)
    public void declareWinner() {
        // This method should contain logic to determine the winner based on the game.
        System.out.println("Winner is declared based on game rules.");
    }
}  