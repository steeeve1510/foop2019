package catsandmice.model;


import java.io.Serializable;
import java.util.Set;

public class Board implements Serializable {

    private int width;
    private int height;

    private Surface surface;
    private Set<Subway> subways;

    public Board(int width, int height, Surface surface, Set<Subway> subways) {
        this.width = width;
        this.height = height;
        this.surface = surface;
        this.subways = subways;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Surface getSurface() {
        return surface;
    }

    public Set<Subway> getSubways() {
        return subways;
    }
}
