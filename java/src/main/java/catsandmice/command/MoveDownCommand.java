package catsandmice.command;

import catsandmice.model.Coordinate;
import catsandmice.model.Game;
import catsandmice.model.Player;
import catsandmice.model.Position;

/**
 * This command moves a player one step down if the next step isn't a wall
 */
public class MoveDownCommand implements Command {

    private Player player;
    private boolean executed = false;

    public MoveDownCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute(Game game) {
        if (executed) {
            return;
        }
        var currentCoordinate = player.getPosition().getCoordinate();
        var currentLayer = player.getPosition().getLayer();

        if (0 >= currentCoordinate.getY()) {
            return;
        }

        var newCoordinate = new Coordinate(currentCoordinate.getX(), currentCoordinate.getY() - 1);
        var newPosition = new Position(newCoordinate, currentLayer);
        player.setPosition(newPosition);
        executed = true;
    }
}
