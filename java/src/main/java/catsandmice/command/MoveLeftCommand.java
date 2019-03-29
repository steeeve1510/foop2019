package catsandmice.command;

import catsandmice.model.Game;
import catsandmice.model.Player;

/**
 * This command moves a player on step to the left if the next step isn't a wall
 */
public class MoveLeftCommand implements Command {

    private Player player;

    public MoveLeftCommand(Player player) {
        this.player = player;
    }

    @Override
    public Game execute(Game game) {
        return null;
    }
}
