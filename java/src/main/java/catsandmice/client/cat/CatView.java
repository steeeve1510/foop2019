package catsandmice.client.cat;

import catsandmice.model.Position;

/**
 * This class should contain all the information a cat can see at some point during the game
 */
public class CatView {
    private Position currentPosition;

    public CatView(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }
}
