package catsandmice.model;

import catsandmice.client.mouse.MouseClient;
import catsandmice.client.mouse.MouseView;
import catsandmice.command.Command;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Mouse implements Player {

    private MouseClient mouseClient;
    private Position position;
    private boolean dead = false;

    public Mouse(MouseClient mouseClient, Position position) {
        this.mouseClient = mouseClient;
        this.position = position;
        this.mouseClient.setMouse(this);
    }

    public boolean isDead() {
        return dead;
    }

    public void kill() {
        dead = true;
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
        return mouseClient.getNextMove();
    }

    @Override
    public void gameOver(String winner) {
        mouseClient.gameOver(winner);
    }

    @Override
    public void update(Game game) {

        var miceOnCurrentLayer = game.getMice().stream()
                .filter(m -> m.getPosition().getLayer().equals(position.getLayer()))
                .collect(Collectors.toSet());
        var aliveMiceOnCurrentLayer = miceOnCurrentLayer.stream()
                .filter(m -> !m.isDead())
                .map(m -> m.getPosition().getCoordinate())
                .collect(Collectors.toSet());
        var deadMiceOnCurrentLayer = miceOnCurrentLayer.stream()
                .filter(Mouse::isDead)
                .map(m -> m.getPosition().getCoordinate())
                .collect(Collectors.toSet());

        Set<Coordinate> cats;
        if (position.isOnSurface()) {
            cats = game.getCats().stream()
                    .filter(c -> c.getPosition().getLayer().equals(position.getLayer()))
                    .map(m -> m.getPosition().getCoordinate())
                    .collect(Collectors.toSet());
        } else {
            Subway currentSubway = (Subway) this.position.getLayer();
            cats = currentSubway.getCatsLastSeen();
        }

        Map<Integer, Set<Coordinate>> subways;
        if (position.isOnSurface()) {
            subways = game.getBoard().getSubways().stream()
                    .collect(Collectors.toMap(Subway::getId, Subway::getEntrances));
        } else {
            subways = new HashMap<>();
            var subway = (Subway) position.getLayer();
            subways.put(subway.getId(), subway.getEntrances());
        }
        var goalSubway = game.getGoalSubway();

        MouseView mouseView = new MouseView(dead, position, aliveMiceOnCurrentLayer, deadMiceOnCurrentLayer, cats, subways, goalSubway);
        mouseClient.render(mouseView);
    }
}
