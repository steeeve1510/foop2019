package catsandmice.command;

import catsandmice.model.Game;

/**
 * Every action a player can take is a command
 */
public interface Command {

    /**
     * This method is called by the engine if the command is selected by a player and executes a command
     *
     * @param game the current state of the game
     */
    void execute(Game game);
}
