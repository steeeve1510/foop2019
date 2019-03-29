package catsandmice.command;

import catsandmice.model.Game;
import catsandmice.model.Player;

/**
 * This command moves a player one step to the right if the next step isn't a wall
 */
public class MoveRightCommand implements Command {

    private Player player;

    public MoveRightCommand(Player player) {
        this.player = player;
    }

    @Override
    public Game execute(Game game) {
        return null;
    }
}
