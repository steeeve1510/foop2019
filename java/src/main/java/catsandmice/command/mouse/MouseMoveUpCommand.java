package catsandmice.command.mouse;

import catsandmice.command.Command;
import catsandmice.command.MoveUpCommand;
import catsandmice.model.Mouse;

public class MouseMoveUpCommand extends MouseMoveCommand {

    private Mouse mouse;

    public MouseMoveUpCommand(Mouse mouse) {
        this.mouse = mouse;
    }

    @Override
    Command getMoveCommand() {
        return new MoveUpCommand(mouse);
    }
}
