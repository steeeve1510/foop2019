package catsandmice;

import catsandmice.engine.Config;
import catsandmice.engine.Engine;

public class App {
    public static void main(String[] args) {

        // create config of the game
        Config config = new Config();

        Engine engine = new Engine(config);
        engine.run();
    }
}
