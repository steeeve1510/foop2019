package catsandmice.model;

import catsandmice.client.mouse.MouseClient;
import catsandmice.client.mouse.MouseView;
import catsandmice.command.Command;

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
        // TODO calculate MouseView
        MouseView mouseView = new MouseView();
        mouseClient.render(mouseView);
    }
}
