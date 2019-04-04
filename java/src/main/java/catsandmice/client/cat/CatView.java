package catsandmice.client.cat;

import catsandmice.model.Cat;
import catsandmice.model.Coordinate;
import catsandmice.model.Mouse;
import catsandmice.model.Position;

import java.util.Set;

/**
 * This class should contain all the information a cat can see at some point during the game
 */
public class CatView {
    private Position currentPosition;
    private Set<Cat> cats;
    private Set<Mouse> mice;
    private Set<Mouse> deadMice;
    private Set<Coordinate> entrances;

    public CatView(Position currentPosition, Set<Cat> cats, Set<Mouse> mice, Set<Mouse> deadMice, Set<Coordinate> entrances) {
        this.currentPosition = currentPosition;
        this.cats = cats;
        this.mice = mice;
        this.deadMice = deadMice;
        this.entrances = entrances;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public Set<Cat> getCats() {
        return cats;
    }

    public Set<Mouse> getMice() {
        return mice;
    }

    public Set<Mouse> getDeadMice() {
        return deadMice;
    }

    public Set<Coordinate> getEntrances() {
        return entrances;
    }
}
