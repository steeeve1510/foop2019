package catsandmice.client.cat;

import catsandmice.model.Coordinate;
import catsandmice.model.Position;

import java.io.Serializable;
import java.util.Set;

/**
 * This class should contain all the information a cat can see at some point during the game
 */
public class CatView implements Serializable {
    private Position currentPosition;
    private Set<Coordinate> cats;
    private Set<Coordinate> mice;
    private Set<Coordinate> deadMice;
    private Set<Coordinate> entrances;

    public CatView(Position currentPosition, Set<Coordinate> cats, Set<Coordinate> mice, Set<Coordinate> deadMice, Set<Coordinate> entrances) {
        this.currentPosition = currentPosition;
        this.cats = cats;
        this.mice = mice;
        this.deadMice = deadMice;
        this.entrances = entrances;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public Set<Coordinate> getCats() {
        return cats;
    }

    public Set<Coordinate> getMice() {
        return mice;
    }

    public Set<Coordinate> getDeadMice() {
        return deadMice;
    }

    public Set<Coordinate> getEntrances() {
        return entrances;
    }
}
