package catsandmice.engine;

import catsandmice.client.cat.CatBotClient;
import catsandmice.client.cat.CatClient;
import catsandmice.client.cat.CatUserClient;
import catsandmice.client.mouse.MouseBotClient;
import catsandmice.client.mouse.MouseClient;
import catsandmice.model.*;

import java.util.HashSet;
import java.util.Set;
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
        for (var i = 0; i < config.getNumberOfSubways(); i++) {
            var subway = createSubway(subways);
            subways.add(subway);
        }
        var goalSubway = subways.stream()
                .findFirst()
                .orElse(null);
        var subwaysWithoutGoal = subways.stream()
                .filter(s -> s != goalSubway)
                .collect(Collectors.toSet());

        var board = new Board(config.getHeight(), config.getWidth(), surface, subways);

        Set<Cat> cats = new HashSet<>();
        for (var i = 0; i < config.getNumberOfCatBots(); i++) {
            var catBotClient = new CatBotClient();
            var catBot = getCat(catBotClient, surface);
            cats.add(catBot);
        }

        Set<Mouse> mice = new HashSet<>();
        for (var i = 0; i < config.getNumberOfMiceBots(); i++) {
            var mouseBotClient = new MouseBotClient();
            var mouseBot = getMouse(mouseBotClient, subwaysWithoutGoal);
            mice.add(mouseBot);
        }

//        var mouseClient = new MouseUserClient(config);
//        var mouse = getMouse(mouseClient, subwaysWithoutGoal);
//        mice.add(mouse);

//        var catClient = new CatUserClient(config);
//        var cat = getCat(catClient, surface);
//        cats.add(cat);

        return new Game(board, goalSubway, mice, cats);
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
