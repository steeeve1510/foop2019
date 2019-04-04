package catsandmice.model;

import java.util.Objects;

public class Position {

    private Coordinate coordinate;
    private Layer layer;

    public Position(Coordinate coordinate, Layer layer) {
        this.coordinate = coordinate;
        this.layer = layer;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Layer getLayer() {
        return layer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Objects.equals(coordinate, position.coordinate) &&
                Objects.equals(layer, position.layer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate, layer);
    }
}
