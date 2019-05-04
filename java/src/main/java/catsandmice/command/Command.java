package catsandmice.command;

import catsandmice.model.Game;

import java.io.Serializable;

/**
 * Every action a player can take is a command
 */
public interface Command extends Serializable {

    /**
     * This method is called by the engine if the command is selected by a player and executes a command
     *
     * @param game the current state of the game
     */
    void execute(Game game);
}
