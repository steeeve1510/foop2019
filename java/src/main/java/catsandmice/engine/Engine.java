package catsandmice.engine;

import catsandmice.model.Game;
import catsandmice.model.Player;

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
                    .map(Player::getNextMove)
                    .collect(Collectors.toList());

            // execute next moves
            for (var command : commands) {
                game = command.execute(game);
            }

            // check if any mouse is dead;
            game = this.killMice(game);

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

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException("How could this happen?", e);
            }

        } while (true);
    }

    /**
     * Checks if any mice and cats are on the same field on the surface. If so the mouse dies.
     *
     * @param game the current state of the game
     * @return the state of the game with mice been marked as killed
     */
    private Game killMice(Game game) {
        return game;
    }

    /**
     * Determines if the game is over, if so the name of the winner (either 'Cats' or 'Mice') is returned
     *
     * @param game the current state of the game
     * @return either 'Cats' or 'Mice' it the game is over, otherwise null
     */
    private String getWinner(Game game) {
        return null;
    }
}