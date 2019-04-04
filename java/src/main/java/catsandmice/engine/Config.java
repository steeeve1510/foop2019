package catsandmice.engine;

/**
 * This class represents the configuration of the game
 * e.g. how many AI players are given, how large is the board, etc...
 */
public class Config {

    private int height = 10;
    private int width = 10;
    private int numberOfSubways = 2;

    int getHeight() {
        return height;
    }

    int getWidth() {
        return width;
    }

    int getNumberOfSubways() {
        return numberOfSubways;
    }
}
