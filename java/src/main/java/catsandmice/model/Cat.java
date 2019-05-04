package catsandmice.model;

import catsandmice.client.cat.CatClient;
import catsandmice.client.cat.CatView;
import catsandmice.command.Command;

import java.io.Serializable;
import java.util.stream.Collectors;

public class Cat implements Player, Serializable {

    private CatClient catClient;
    private Position position;

    public Cat(CatClient catClient, Position position) {
        this.catClient = catClient;
        this.position = position;
        this.catClient.setCat(this);
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
    public boolean isDead() {
        return false;
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
        var cats = game.getCats().stream()
                .map(c -> c.getPosition().getCoordinate())
                .collect(Collectors.toSet());

        var miceOnSurface = game.getMice().stream()
                .filter(m -> m.getPosition().getLayer().equals(game.getBoard().getSurface()))
                .collect(Collectors.toSet());
        var aliveMiceOnSurface = miceOnSurface.stream()
                .filter(m -> !m.isDead())
                .map(m -> m.getPosition().getCoordinate())
                .collect(Collectors.toSet());
        var deadMiceOnSurface = miceOnSurface.stream()
                .filter(Mouse::isDead)
                .map(m -> m.getPosition().getCoordinate())
                .collect(Collectors.toSet());

        var subwayEntrances = game.getBoard().getSubways().stream()
                .flatMap(s -> s.getEntrances().stream())
                .collect(Collectors.toSet());

        CatView catView = new CatView(position, cats, aliveMiceOnSurface, deadMiceOnSurface, subwayEntrances);
        catClient.render(catView);
    }

}
