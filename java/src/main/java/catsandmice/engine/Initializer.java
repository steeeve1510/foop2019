package catsandmice.engine;

import catsandmice.client.cat.CatClient;
import catsandmice.client.cat.CatUserClient;
import catsandmice.client.mouse.MouseClient;
import catsandmice.client.mouse.MouseUserClient;
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
        var surface = new Surface();
        var subways = new HashSet<Subway>();
        for(var i = 0; i < config.getNumberOfSubways(); i++) {
            var subway = createSubway(subways);
            subways.add(subway);
        }

        var board = new Board(config.getHeight(), config.getWidth(), surface, subways);

        var catClient = new CatUserClient(config);
        var cat = getCat(catClient, surface);

        var mouseClient = new MouseUserClient(config);
        var mouse = getMouse(mouseClient, subways);

        Set<Cat> cats = new HashSet<>();
//        cats.add(cat);

        Set<Mouse> mice = new HashSet<>();
        mice.add(mouse);

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

    private Cat getCat(CatClient catClient, Surface surface) {
        var coordinate = getRandomCoordinate(config.getHeight(), config.getWidth());

        var position = new Position(coordinate, surface);
        return new Cat(catClient, position);
    }

    private Mouse getMouse(MouseClient mouseClient, Set<Subway> subways) {
        var coordinate = getRandomCoordinate(config.getHeight(), config.getWidth());

        int randomSubwayIndex = (int) (subways.size() * Math.random());
        Subway randomSubway = subways.toArray(new Subway[]{})[randomSubwayIndex];
        var position = new Position(coordinate, randomSubway);
        return new Mouse(mouseClient, position);
    }
}
