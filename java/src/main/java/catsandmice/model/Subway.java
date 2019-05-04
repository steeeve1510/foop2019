package catsandmice.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Subway implements Layer, Serializable {

    private static int counter = 0;

    private int id = 0;
    private Set<Coordinate> entrances;
    private Set<Coordinate> catsLastSeen = new HashSet<>();

    public Subway(Set<Coordinate> entrances) {
        this.id = ++counter;
        this.entrances = entrances;
    }

    public int getId() {
        return id;
    }

    public Set<Coordinate> getEntrances() {
        return entrances;
    }

    public Set<Coordinate> getCatsLastSeen() {
        return catsLastSeen;
    }

    public void setCatsLastSeen(Set<Coordinate> catsLastSeen) {
        this.catsLastSeen = catsLastSeen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subway subway = (Subway) o;
        return Objects.equals(entrances, subway.entrances) &&
                Objects.equals(catsLastSeen, subway.catsLastSeen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entrances, catsLastSeen);
    }
}
