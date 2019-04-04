package catsandmice.model;


import java.util.Set;

public class Board implements Layer {

    private int width;
    private int height;

    private Set<Subway> subways;

    public Board(int width, int height, Set<Subway> subways) {
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

    public Set<Subway> getSubways() {
        return subways;
    }
}
