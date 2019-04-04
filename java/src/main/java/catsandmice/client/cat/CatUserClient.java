package catsandmice.client.cat;

import catsandmice.command.*;
import catsandmice.model.Cat;

/**
 * The GUI implementation of a cat
 */
public class CatUserClient implements CatClient {

    private Cat cat;

    @Override
    public void setCat(Cat cat) {
        this.cat = cat;
    }

    @Override
    public void render(CatView view) {
        System.out.println(view.getCurrentPosition().getCoordinate());
    }

    @Override
    public Command getNextMove() {
        return new MoveUpCommand(cat);
    }

    @Override
    public void gameOver(String winner) {
        System.out.println("GAME OVER!\nThe winner is: " + winner);
    }
}
