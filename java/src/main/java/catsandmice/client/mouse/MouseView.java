package catsandmice.client.mouse;

import catsandmice.model.*;

import java.util.Set;

/**
 * This class should contain all the information a mouse can see at some point during the game
 */
public class MouseView {

    private boolean isDead;
    private Position currentPosition;
    private Set<Coordinate> mice;
    private Set<Coordinate> deadMice;
    private Set<Coordinate> cats;
    private Set<Subway> subways;
    private Subway goalSubway;

    public MouseView(boolean isDead, Position currentPosition, Set<Coordinate> mice, Set<Coordinate> deadMice, Set<Coordinate> cats, Set<Subway> subways, Subway goalSubway) {
        this.isDead = isDead;
        this.currentPosition = currentPosition;
        this.mice = mice;
        this.deadMice = deadMice;
        this.cats = cats;
        this.subways = subways;
        this.goalSubway = goalSubway;
    }

    public boolean isDead() {
        return isDead;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public Set<Coordinate> getMice() {
        return mice;
    }

    public Set<Coordinate> getDeadMice() {
        return deadMice;
    }

    public Set<Coordinate> getCats() {
        return cats;
    }

    public Set<Subway> getSubways() {
        return subways;
    }

    public Subway getGoalSubway() {
        return goalSubway;
    }
}
