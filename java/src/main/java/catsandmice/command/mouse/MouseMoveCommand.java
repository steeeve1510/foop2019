package catsandmice.command.mouse;

import catsandmice.command.Command;
import catsandmice.model.Game;

public abstract class MouseMoveCommand implements Command {

    @Override
    public Game execute(Game game) {
        if (game.getFrameCounter() % 2 == 0) {
            return game;
        }
        Command command = getMoveCommand();
        return command.execute(game);
    }

    abstract Command getMoveCommand();
}
