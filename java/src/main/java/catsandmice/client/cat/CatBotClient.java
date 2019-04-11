package catsandmice.client.cat;

import catsandmice.command.*;
import catsandmice.model.Cat;
import catsandmice.model.Coordinate;

import static catsandmice.client.BotUtil.getNearest;

/**
 * The AI for a cat
 */
public class CatBotClient implements CatClient {

    private Cat cat;
    private CatView view;

    @Override
    public void setCat(Cat cat) {
        this.cat = cat;
    }

    @Override
    public void render(CatView view) {
        this.view = view;
    }

    @Override
    public Command getNextMove() {
        if (view == null) {
            return null;
        }
        var currentCoordinate = view.getCurrentPosition().getCoordinate();
        Coordinate mouse = getNearest(currentCoordinate, view.getMice());
        if (mouse == null) {
            return null;
        }

        var xDiff = currentCoordinate.getX() - mouse.getX();
        var yDiff = currentCoordinate.getY() - mouse.getY();

        if (xDiff > 0) {
            return new MoveLeftCommand(cat);
        }
        if (xDiff < 0) {
            return new MoveRightCommand(cat);
        }
        if (yDiff > 0) {
            return new MoveDownCommand(cat);
        }
        if (yDiff < 0) {
            return new MoveUpCommand(cat);
        }
        return null;
    }

    @Override
    public void gameOver(String winner) {
    }
}
