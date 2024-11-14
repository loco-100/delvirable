
package ca.sheridancollege.project;

public class WarGame extends Game {
    public WarGame(String name) {
        super(name);
    }

    
    @Override
    public void play() {
        // Game logic for "War Game" goes here
        System.out.println("The game is now starting.");
    }

    @Override
    public void declareWinner() {
        // Logic to declare the winner (customize as needed)
        System.out.println("Winner is declared.");
    }
}  