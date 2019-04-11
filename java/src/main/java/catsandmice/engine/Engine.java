package catsandmice.engine;

import catsandmice.model.Cat;
import catsandmice.model.Game;
import catsandmice.model.Mouse;
import catsandmice.model.Player;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Engine {

    private Config config;

    public Engine(Config config) {
        this.config = config;
    }

    public void run() {
        // initialize
        var initializer = new Initializer(config);
        Game game = initializer.initializeGame();

        do {
            // get players
            var mice = game.getMice();
            var cats = game.getCats();
            var players = Stream.concat(mice.stream(), cats.stream()).collect(Collectors.toList());

            // get next moves
            var commands = players.stream()
                    .filter(p -> !p.isDead())
                    .map(Player::getNextMove)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());

            // execute next moves
            for (var command : commands) {
                command.execute(game);
            }

            // check if any mouse is dead;
            killMice(game);

            // check if game is over
            var winner = getWinner(game);

            if (winner != null) {
                players.forEach(p -> p.gameOver(winner));
                break;
            }

            // check for incoming players

            // notify all client the update
            for (var player : players) {
                player.update(game);
            }

            game.increaseFrameCounter();

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException("How could this happen?", e);
            }

        } while (true);
    }

    /**
     * Checks if any mice and cats are on the same field on the surface. If so the mouse dies.
     *
     * @param game the current state of the game
     */
    private void killMice(Game game) {
        var catPositions = game.getCats().stream()
                .map(Cat::getPosition)
                .collect(Collectors.toSet());

        for (Mouse mouse : game.getMice()) {
            var mousePosition = mouse.getPosition();
            if (catPositions.contains(mousePosition)) {
                mouse.kill();
            }
        }
    }

    /**
     * Determines if the game is over, if so the name of the winner (either 'Cats' or 'Mice') is returned
     *
     * @param game the current state of the game
     * @return either 'Cats' or 'Mice' if the game is over, otherwise null
     */
    private String getWinner(Game game) {
        if (game.getFrameCounter() < 100) {
            return null;
        }
        return "Draw";
    }
}
