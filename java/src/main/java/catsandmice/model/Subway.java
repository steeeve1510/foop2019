package catsandmice.model;

import java.util.Objects;
import java.util.Set;

public class Subway implements Layer {

    private Set<Coordinate> entrances;

    public Subway(Set<Coordinate> entrances) {
        this.entrances = entrances;
    }

    public Set<Coordinate> getEntrances() {
        return entrances;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subway subway = (Subway) o;
        return Objects.equals(entrances, subway.entrances);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entrances);
    }
}
