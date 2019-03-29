package catsandmice.model;

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
}
