package catsandmice.command.mouse;

import catsandmice.command.Command;
import catsandmice.command.MoveRightCommand;
import catsandmice.model.Mouse;

public class MouseMoveRightCommand extends MouseMoveCommand {

    private Mouse mouse;

    public MouseMoveRightCommand(Mouse mouse) {
        this.mouse = mouse;
    }

    @Override
    Command getMoveCommand() {
        return new MoveRightCommand(mouse);
    }
}
