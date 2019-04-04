package catsandmice.engine;

import catsandmice.model.Board;
import catsandmice.model.Coordinate;
import catsandmice.model.Game;
import catsandmice.model.Subway;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

class Initializer {

    private Config config;

    Initializer(Config config) {
        this.config = config;
    }

    /**
     * Initializes a new Game with the provided config
     *
     * @return a new game
     */
    Game initializeGame() {

        var subways = new HashSet<Subway>();
        for(var i = 0; i < config.getNumberOfSubways(); i++) {
            var subway = createSubway(config.getHeight(), config.getWidth(), subways);
            subways.add(subway);
        }

        var board = new Board(config.getHeight(), config.getWidth(), subways);


        // create UI with a Cat or a Mouse
        // create random bots

        return null;
    }

    private Subway createSubway(int maxHeight, int maxWidth, Set<Subway> subways) {
        var usedEntrances = subways.stream()
                .flatMap(s -> s.getEntrances().stream())
                .collect(Collectors.toSet());
        var chosenEntrances = new HashSet<Coordinate>();

        var entrance = getNewEntrance(maxHeight, maxWidth, usedEntrances, chosenEntrances);
        chosenEntrances.add(entrance);

        var exit = getNewEntrance(maxHeight, maxWidth, usedEntrances, chosenEntrances);
        chosenEntrances.add(exit);

        return new Subway(chosenEntrances);
    }

    private Coordinate getNewEntrance(int maxHeight, int maxWidth, Set<Coordinate> usedEntrances, Set<Coordinate> chosenEntrances) {
        Coordinate entrance = null;
        while (entrance == null) {
            Coordinate candidate = getRandomCoordinate(maxHeight, maxWidth);
            if (!usedEntrances.contains(candidate) && !chosenEntrances.contains(candidate)) {
                entrance = candidate;
            }
        }
        return entrance;
    }

    private Coordinate getRandomCoordinate(int maxHeight, int maxWidth) {
        var x = (int) (maxWidth * Math.random());
        var y = (int) (maxHeight * Math.random());

        return new Coordinate(x, y);
    }
}
