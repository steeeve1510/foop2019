package catsandmice.engine;

/**
 * This class represents the configuration of the game
 * e.g. how many AI players are given, how large is the board, etc...
 */
public class Config {

    private int height = 10;
    private int width = 10;
    private int numberOfSubways = 4;

    private int windowWidth = 800;
    private int windowHeight = 600;

    private int numberOfMiceBots = 10;
    private int numberOfCatBots = 1;

    private int port = 6666;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getNumberOfSubways() {
        return numberOfSubways;
    }

    public int getWindowWidth() {
        return windowWidth;
    }

    public int getWindowHeight() {
        return windowHeight;
    }

    public int getNumberOfMiceBots() {
        return numberOfMiceBots;
    }

    public int getNumberOfCatBots() {
        return numberOfCatBots;
    }

    public int getPort() {
        return port;
    }
}
