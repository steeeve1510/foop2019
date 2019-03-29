package catsandmice.client.mouse;

import catsandmice.command.Command;
import catsandmice.model.Mouse;

/**
 * The GUI implementation of a mouse
 */
public class MouseUserClient implements MouseClient {

    @Override
    public void setMouse(Mouse mouse) {

    }

    @Override
    public void render(MouseView view) {

    }

    @Override
    public Command getNextMove() {
        return null;
    }

    @Override
    public void gameOver(String winner) {

    }
}
