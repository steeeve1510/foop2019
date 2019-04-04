package catsandmice.client.cat;

import catsandmice.model.Coordinate;
import catsandmice.model.Mouse;
import catsandmice.model.Position;

import java.util.Set;

/**
 * This class should contain all the information a cat can see at some point during the game
 */
public class CatView {
    private Position currentPosition;
    private Set<Mouse> mice;
    private Set<Mouse> deadMice;
    private Set<Coordinate> entrances;

    public CatView(Position currentPosition, Set<Mouse> mice, Set<Mouse> deadMice, Set<Coordinate> entrances) {
        this.currentPosition = currentPosition;
        this.mice = mice;
        this.deadMice = deadMice;
        this.entrances = entrances;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void setMice(Set<Mouse> mice) {
        this.mice = mice;
    }

    public Set<Mouse> getDeadMice() {
        return deadMice;
    }

    public void setEntrances(Set<Coordinate> entrances) {
        this.entrances = entrances;
    }
}
