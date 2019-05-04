package catsandmice.model;

import java.io.Serializable;
import java.util.Set;

public class Game implements Serializable {

    private long frameCounter = 0;

    private Board board;
    private Subway goalSubway;

    private Set<Mouse> mice;
    private Set<Cat> cats;

    public Game(Board board, Subway goalSubway, Set<Mouse> mice, Set<Cat> cats) {
        this.board = board;
        this.goalSubway = goalSubway;
        this.mice = mice;
        this.cats = cats;
    }

    public long getFrameCounter() {
        return frameCounter;
    }

    public Board getBoard() {
        return board;
    }

    public Subway getGoalSubway() {
        return goalSubway;
    }

    public Set<Mouse> getMice() {
        return mice;
    }

    public Set<Cat> getCats() {
        return cats;
    }

    public void increaseFrameCounter() {
        this.frameCounter++;
    }

    public void addMouse(Mouse mouse) {
        this.mice.add(mouse);
    }

    public void addCat(Cat cat) {
        this.cats.add(cat);
    }
}
