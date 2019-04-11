package catsandmice.client;

import catsandmice.model.Coordinate;

import java.util.Comparator;
import java.util.Set;

public class BotUtil {
    public static Coordinate getNearest(Coordinate reference, Set<Coordinate> others) {
        if (others == null) {
            return null;
        }

        return others.stream()
                .map(o -> {
                    var distance = getDistance(reference, o);
                    return new Tuple(distance, o);
                })
                .min(Comparator.naturalOrder())
                .map(Tuple::getSecond)
                .orElse(null);
    }

    private static int getDistance(Coordinate c1, Coordinate c2) {
        return Math.abs(c1.getX() - c2.getX()) + Math.abs(c1.getY() - c2.getY());
    }

    private static class Tuple implements Comparable<Tuple> {
        private int first;
        private Coordinate second;

        Tuple(int first, Coordinate second) {
            this.first = first;
            this.second = second;
        }

        int getFirst() {
            return first;
        }

        Coordinate getSecond() {
            return second;
        }

        @Override
        public int compareTo(Tuple tuple) {
            return this.first - tuple.first;
        }
    }
}
