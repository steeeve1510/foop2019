package catsandmice.command.mouse;

import catsandmice.command.Command;
import catsandmice.command.MoveDownCommand;
import catsandmice.model.Mouse;

public class MouseMoveDownCommand extends MouseMoveCommand {

    private Mouse mouse;

    public MouseMoveDownCommand(Mouse mouse) {
        this.mouse = mouse;
    }

    @Override
    Command getMoveCommand() {
        return new MoveDownCommand(mouse);
    }
}
