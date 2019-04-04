package catsandmice.command.mouse;

import catsandmice.command.Command;
import catsandmice.model.Game;

public abstract class MouseMoveCommand implements Command {

    @Override
    public void execute(Game game) {
        if (game.getFrameCounter() % 2 == 0) {
            return;
        }
        getMoveCommand().execute(game);
    }

    abstract Command getMoveCommand();
}
