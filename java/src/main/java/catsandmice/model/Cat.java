package catsandmice.model;

import catsandmice.client.cat.CatClient;
import catsandmice.client.cat.CatView;
import catsandmice.command.Command;

public class Cat implements Player {

    private CatClient catClient;
    private Position position;

    public Cat(CatClient catClient, Position position) {
        this.catClient = catClient;
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public Command getNextMove() {
        return catClient.getNextMove();
    }

    @Override
    public void gameOver(String winner) {
        catClient.gameOver(winner);
    }

    @Override
    public void update(Game game) {
        // TODO calculate cat view out of game
        CatView catView = new CatView();
        catClient.render(catView);
    }

}
