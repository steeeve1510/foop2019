package catsandmice.command;

import catsandmice.model.Coordinate;
import catsandmice.model.Game;
import catsandmice.model.Player;
import catsandmice.model.Position;

/**
 * This command moves a player on step to the left if the next step isn't a wall
 */
public class MoveLeftCommand implements Command {

    private Player player;
    private boolean executed = false;

    public MoveLeftCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute(Game game) {
        if (executed) {
            return;
        }
        var currentCoordinate = player.getPosition().getCoordinate();
        var currentLayer = player.getPosition().getLayer();

        if (0 >= currentCoordinate.getX()) {
            return;
        }

        var newCoordinate = new Coordinate(currentCoordinate.getX()-1, currentCoordinate.getY());
        var newPosition = new Position(newCoordinate, currentLayer);
        player.setPosition(newPosition);
        executed = true;
    }
}
