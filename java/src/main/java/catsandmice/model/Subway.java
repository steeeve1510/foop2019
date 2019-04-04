package catsandmice.model;

import java.util.Set;

public class Subway implements Layer {

    private Set<Coordinate> entrances;

    public Subway(Set<Coordinate> entrances) {
        this.entrances = entrances;
    }

    public Set<Coordinate> getEntrances() {
        return entrances;
    }
}
