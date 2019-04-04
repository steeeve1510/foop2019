package catsandmice.model;

import catsandmice.command.Command;

public interface Player {

    Position getPosition();
    void setPosition(Position position);

    boolean isDead();

    Command getNextMove();
    void update(Game game);
    void gameOver(String winner);
}
