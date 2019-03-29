package catsandmice.command.mouse;

import catsandmice.command.Command;
import catsandmice.model.Game;
import catsandmice.model.Mouse;
import catsandmice.model.Player;

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
    public Game execute(Game game) {
        return null;
    }
}
