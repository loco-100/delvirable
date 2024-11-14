 /**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Author: Rajanpreet Kaur
 * Date: 2024-11-14
 */
package ca.sheridancollege.project;

public class Player {

    private final String name; // the unique name for this player

    // Constructor to set the player's unique ID
    public Player(String name) {
        this.name = name;
    }

    // Getter for player name
    public String getName() {
        return name;
    }

    // Method to play the game 
    public void play() {
        System.out.println(name + " is playing their turn.");
    }
}   
