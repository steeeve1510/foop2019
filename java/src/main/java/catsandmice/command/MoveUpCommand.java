package catsandmice.command;

import catsandmice.model.Coordinate;
import catsandmice.model.Game;
import catsandmice.model.Player;
import catsandmice.model.Position;

/**
 * This command moves a player one step up if the next step isn't a wall
 */
public class MoveUpCommand implements Command {

    private Player player;

    public MoveUpCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute(Game game) {
        var maxHeight = game.getBoard().getHeight();

        var currentCoordinate = player.getPosition().getCoordinate();

        var currentLayer = player.getPosition().getLayer();

        if (maxHeight <= currentCoordinate.getY() + 1) {
            return;
        }

        var newCoordinate = new Coordinate(currentCoordinate.getX(), currentCoordinate.getY()+1);
        var newPosition = new Position(newCoordinate, currentLayer);
        player.setPosition(newPosition);
    }
}
