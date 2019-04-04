package catsandmice.model;

import catsandmice.client.mouse.MouseClient;
import catsandmice.client.mouse.MouseView;
import catsandmice.command.Command;

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

        var miceOnSurface = game.getMice().stream()
                .filter(m -> m.getPosition().getLayer().equals(position.getLayer()))
                .collect(Collectors.toSet());
        var aliveMiceOnCurrentLayer = miceOnSurface.stream()
                .filter(m -> !m.isDead())
                .collect(Collectors.toSet());
        var deadMiceOnCurrentLayer = miceOnSurface.stream()
                .filter(Mouse::isDead)
                .collect(Collectors.toSet());

        var cats = game.getCats().stream()
                .filter(c -> c.getPosition().getLayer().equals(position.getLayer()))
                .collect(Collectors.toSet());

        var subways = game.getBoard().getSubways();
        var goalSubway = game.getGoalSubway();

        MouseView mouseView = new MouseView(position, aliveMiceOnCurrentLayer, deadMiceOnCurrentLayer, cats, subways, goalSubway);
        mouseClient.render(mouseView);
    }
}
