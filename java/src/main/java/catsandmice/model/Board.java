package catsandmice.model;


import java.util.List;

public class Board implements Layer {

    private int width;
    private int height;

    private List<Subway> subways;

    public Board(int width, int height, List<Subway> subways) {
        this.width = width;
        this.height = height;
        this.subways = subways;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Subway> getSubways() {
        return subways;
    }
}
