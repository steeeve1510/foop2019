package catsandmice.command;

import catsandmice.model.Coordinate;
import catsandmice.model.Game;
import catsandmice.model.Player;
import catsandmice.model.Position;

/**
 * This command moves a player one step to the right if the next step isn't a wall
 */
public class MoveRightCommand implements Command {

    private Player player;
    private boolean executed = false;

    public MoveRightCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute(Game game) {
        if (executed) {
            return;
        }
        var maxWidth = game.getBoard().getWidth();

        var currentCoordinate = player.getPosition().getCoordinate();
        var currentLayer = player.getPosition().getLayer();

        if (maxWidth <= currentCoordinate.getX() + 1) {
            return;
        }

        var newCoordinate = new Coordinate(currentCoordinate.getX()+1, currentCoordinate.getY());
        var newPosition = new Position(newCoordinate, currentLayer);
        player.setPosition(newPosition);
        executed = true;
    }

}
