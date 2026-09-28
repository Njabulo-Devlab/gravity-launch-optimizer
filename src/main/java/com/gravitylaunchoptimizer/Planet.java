package com.gravitylaunchoptimizer;

public class Planet {
    private final String name;
    private final double radiusMeters;
    private final double massKg;

    public Planet(String name, double radiusMeters, double massKg) {
        this.name = name;
        this.radiusMeters = radiusMeters;
        this.massKg = massKg;
    }

    public String getName() {
        return name;
    }

    public double getRadiusMeters() {
        return radiusMeters;
    }

    public double getMassKg() {
        return massKg;
    }

    public double gravityAtAltitude(double altitudeMeters) {
        double safeAltitude = Math.max(0.0, altitudeMeters);
        double G = 6.67430e-11;
        double distanceFromCenter = radiusMeters + safeAltitude;
        return G * massKg / (distanceFromCenter * distanceFromCenter);
    }
}
