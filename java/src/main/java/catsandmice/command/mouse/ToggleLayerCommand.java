package catsandmice.command.mouse;

import catsandmice.command.Command;
import catsandmice.model.*;

import java.util.Set;

/**
 * This command changes the layer of a mouse
 * If the mouse is on the surface and on an entrance to a subway it enters it
 * If the mouse is in a subway and on an exit and leaves the subway and enters the surface
 */
public class ToggleLayerCommand implements Command {

    private Mouse mouse;
    private Set<Coordinate> catsLastSeen;
    private boolean executed = false;

    public ToggleLayerCommand(Mouse mouse) {
        this.mouse = mouse;

    }

    public void initialize(Set<Coordinate> catsLastSeen) {
        this.catsLastSeen = catsLastSeen;
    }

    @Override
    public void execute(Game game) {
        if (catsLastSeen == null) {
            throw new RuntimeException("ToggleLayerCommand not initialized");
        }
        if (executed) {
            return;
        }
        var currentCoordinate = mouse.getPosition().getCoordinate();
        var currentLayer = mouse.getPosition().getLayer();

        var subway = findSubwayWithEntrance(currentCoordinate, game.getBoard().getSubways());
        if (subway == null) {
            return;
        }

        var surface = game.getBoard().getSurface();
        Layer newLayer;
        if (currentLayer.equals(surface)) {
            newLayer = subway;
            subway.setCatsLastSeen(catsLastSeen);
        } else {
            newLayer = surface;
        }
        var newPosition = new Position(currentCoordinate, newLayer);
        mouse.setPosition(newPosition);
        executed = true;
    }

    private Subway findSubwayWithEntrance(Coordinate entrance, Set<Subway> subways) {
        return subways.stream()
                .filter(s -> s.getEntrances().contains(entrance))
                .findFirst()
                .orElse(null);
    }
}
