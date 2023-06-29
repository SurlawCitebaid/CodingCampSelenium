package Strategies;

import Models.Planet;

public class DistanceMatchingStrategy implements MatchingStrategy{

    long distance;

    public DistanceMatchingStrategy(long distance){
        this.distance = distance;
    }

    @Override
    public boolean match(Planet planet) {
        return planet.getDistFromTheSun() == distance;
    }
}
