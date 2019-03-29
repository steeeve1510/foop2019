package catsandmice.client;

import catsandmice.command.Command;

/**
 * A generic Client for either mouse or cat
 */
public interface Client {

    /**
     * returns the move for the next frame
     * @return the move for the next frame
     */
    Command getNextMove();

    /**
     * Is called if the game is over and a winner is determined
     *
     * @param winner the name of the winner
     */
    void gameOver(String winner);
}
