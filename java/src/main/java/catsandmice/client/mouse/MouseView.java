package catsandmice.client.mouse;

import catsandmice.model.Cat;
import catsandmice.model.Mouse;
import catsandmice.model.Position;
import catsandmice.model.Subway;

import java.util.Set;

/**
 * This class should contain all the information a mouse can see at some point during the game
 */
public class MouseView {

    private Position position;
    private Set<Mouse> mice;
    private Set<Mouse> deadMice;
    private Set<Cat> cats;
    private Set<Subway> subways;
    private Subway goalSubway;

    public MouseView(Position position, Set<Mouse> mice, Set<Mouse> deadMice, Set<Cat> cats, Set<Subway> subways, Subway goalSubway) {
        this.position = position;
        this.mice = mice;
        this.deadMice = deadMice;
        this.cats = cats;
        this.subways = subways;
        this.goalSubway = goalSubway;
    }

    public Position getPosition() {
        return position;
    }

    public Set<Mouse> getMice() {
        return mice;
    }

    public Set<Mouse> getDeadMice() {
        return deadMice;
    }

    public Set<Cat> getCats() {
        return cats;
    }

    public Set<Subway> getSubways() {
        return subways;
    }

    public Subway getGoalSubway() {
        return goalSubway;
    }
}
