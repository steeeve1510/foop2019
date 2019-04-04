package catsandmice.command.mouse;

import catsandmice.command.Command;
import catsandmice.model.*;

/**
 * This command changes the layer of a mouse
 * If the mouse is on the surface and on an entrance to a subway it enters it
 * If the mouse is in a subway and on an exit and leaves the subway and enters the surface
 */
public class ToggleLayerCommand implements Command {

    private Mouse mouse;

    public ToggleLayerCommand(Mouse mouse) {
        this.mouse = mouse;
    }

    @Override
    public void execute(Game game) {
        var currentCoordinate = mouse.getPosition().getCoordinate();
        var currentLayer = mouse.getPosition().getLayer();

        var subway = findSubwayWithEntrance(currentCoordinate, game);
        if (subway == null) {
            return;
        }

        Layer newLayer;
        if (currentLayer.equals(game.getBoard())) {
            newLayer = subway;
        } else {
            newLayer = game.getBoard();
        }
        var newPosition = new Position(currentCoordinate, newLayer);
        mouse.setPosition(newPosition);
    }

    private Subway findSubwayWithEntrance(Coordinate entrance, Game game) {
        return null;
    }
}
