package catsandmice.model;


import java.util.List;

public class Game {

    private long frameCounter = 0;

    private Board board;
    private Subway goalSubway;

    private List<Mouse> mice;
    private List<Cat> cats;

    public Game(Board board, Subway goalSubway, List<Mouse> mice, List<Cat> cats) {
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

    public List<Mouse> getMice() {
        return mice;
    }

    public List<Cat> getCats() {
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
