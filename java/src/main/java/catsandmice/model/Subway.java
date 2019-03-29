package catsandmice.model;

import java.util.List;

public class Subway implements Layer {

    private List<Coordinate> entrances;

    public Subway(List<Coordinate> entrances) {
        this.entrances = entrances;
    }

    public List<Coordinate> getEntrances() {
        return entrances;
    }
}
