package catsandmice.command;

import catsandmice.model.Game;

/**
 * Every action a player can take is a command
 */
public interface Command {

    /**
     * This method is called by the engine if the command is selected by a player
     *
     * @param game the current state of the game
     * @return the state of the game after the command is executed
     */
    Game execute(Game game);
}
