package catsandmice.engine;

import catsandmice.client.cat.CatClient;
import catsandmice.client.cat.CatUserClient;
import catsandmice.model.*;

import java.util.*;
import java.util.stream.Collectors;

class Initializer {

    private final Config config;

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
            var subway = createSubway(subways);
            subways.add(subway);
        }

        var board = new Board(config.getHeight(), config.getWidth(), subways);

        var catClient = new CatUserClient();
        var cat = getCat(catClient, board);

        List<Cat> cats = Arrays.asList(cat);
        List<Mouse> mice = new ArrayList<>();

        return new Game(board, subways.iterator().next(), mice, cats);
    }

    private Subway createSubway(Set<Subway> subways) {
        var usedEntrances = subways.stream()
                .flatMap(s -> s.getEntrances().stream())
                .collect(Collectors.toSet());
        var chosenEntrances = new HashSet<Coordinate>();

        var entrance = getNewEntrance(config.getHeight(), config.getWidth(), usedEntrances, chosenEntrances);
        chosenEntrances.add(entrance);

        var exit = getNewEntrance(config.getHeight(), config.getWidth(), usedEntrances, chosenEntrances);
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

    private Cat getCat(CatClient catClient, Board board) {
        var coordinate = getRandomCoordinate(config.getHeight(), config.getWidth());

        var position = new Position(coordinate, board);
        return new Cat(catClient, position);
    }
}
