package ca.sheridancollege.project;

public class WarPlayer extends Player {
    public WarPlayer(String name) {
        super(name);
    }

    @Override
    public void play() {
        // Player-specific actions during the game
        System.out.println(getName() + " is playing.");
    }
}