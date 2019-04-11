package catsandmice.client.mouse;

import catsandmice.client.BotUtil;
import catsandmice.command.*;
import catsandmice.command.mouse.*;
import catsandmice.model.Coordinate;
import catsandmice.model.Mouse;
import catsandmice.model.Subway;

/**
 * The AI for a mouse
 */
public class MouseBotClient implements MouseClient {

    private Mouse mouse;
    private MouseView view;

    @Override
    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    @Override
    public void render(MouseView view) {
        this.view = view;
    }

    @Override
    public Command getNextMove() {
        if (view == null) {
            return null;
        }
        var currentCoordinate = view.getCurrentPosition().getCoordinate();

        Coordinate destination;
        if (view.getCurrentPosition().isOnSurface()) {
            destination = BotUtil.getNearest(currentCoordinate, view.getGoalSubway().getEntrances());
        } else {
            var subway = (Subway) view.getCurrentPosition().getLayer();
            if (subway.equals(view.getGoalSubway())) {
                return new MouseMoveUpCommand(mouse);
            }
            destination = BotUtil.getNearest(currentCoordinate, subway.getEntrances());
        }

        var xDiff = currentCoordinate.getX() - destination.getX();
        var yDiff = currentCoordinate.getY() - destination.getY();

        if (xDiff > 0) {
            return new MouseMoveLeftCommand(mouse);
        }
        if (xDiff < 0) {
            return new MouseMoveRightCommand(mouse);
        }
        if (yDiff > 0) {
            return new MouseMoveDownCommand(mouse);
        }
        if (yDiff < 0) {
            return new MouseMoveUpCommand(mouse);
        }

        var toggle = new ToggleLayerCommand(mouse);
        toggle.initialize(view.getCats());
        return toggle;
    }

    @Override
    public void gameOver(String winner) {
    }
}
