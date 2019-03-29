package catsandmice.command.mouse;

import catsandmice.command.Command;
import catsandmice.command.MoveLeftCommand;
import catsandmice.model.Mouse;

public class MouseMoveLeftCommand extends MouseMoveCommand {

    private Mouse mouse;

    public MouseMoveLeftCommand(Mouse mouse) {
        this.mouse = mouse;
    }

    @Override
    Command getMoveCommand() {
        return new MoveLeftCommand(mouse);
    }
}
