package catsandmice.command;

import catsandmice.model.Game;
import catsandmice.model.Player;

/**
 * This command moves a player one step up if the next step isn't a wall
 */
public class MoveUpCommand implements Command {

    private Player player;

    public MoveUpCommand(Player player) {
        this.player = player;
    }

    @Override
    public Game execute(Game game) {
        return null;
    }
}
