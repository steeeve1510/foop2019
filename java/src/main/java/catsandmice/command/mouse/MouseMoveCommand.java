package catsandmice.command.mouse;

import catsandmice.command.Command;
import catsandmice.model.Game;

public abstract class MouseMoveCommand implements Command {

    private boolean executed = false;

    @Override
    public void execute(Game game) {
        if (executed) {
            return;
        }
        if (game.getFrameCounter() % 2 == 0) {
            return;
        }
        getMoveCommand().execute(game);
        executed = true;
    }

    abstract Command getMoveCommand();
}
