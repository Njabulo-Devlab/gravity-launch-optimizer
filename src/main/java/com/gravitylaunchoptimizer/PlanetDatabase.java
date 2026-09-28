package com.gravitylaunchoptimizer;

import java.util.LinkedHashMap;
import java.util.Map;

public final class PlanetDatabase {
    private static final Map<String, Planet> PLANETS = new LinkedHashMap<>();

    static {
        PLANETS.put("Earth", new Planet("Earth", 6.371e6, 5.97219e24));
        PLANETS.put("Mars", new Planet("Mars", 3.3895e6, 6.4171e23));
        PLANETS.put("Moon", new Planet("Moon", 1.7374e6, 7.342e22));
    }

    private PlanetDatabase() {}

    public static Map<String, Planet> getPlanets() {
        return PLANETS;
    }

    public static Planet get(String name) {
        Planet planet = PLANETS.get(name);
        if (planet == null) {
            throw new IllegalArgumentException("Unknown planet: " + name);
        }
        return planet;
    }
}
