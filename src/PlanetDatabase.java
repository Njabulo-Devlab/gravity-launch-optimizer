import java.util.ArrayList;
import java.util.List;

public class PlanetDatabase {

    public static List<Planet> getPlanets() {

        List<Planet> planets = new ArrayList<>();

        planets.add(new Planet(
                "Earth",
                6371000,
                5.972e24,
                9.81
        ));

        planets.add(new Planet(
                "Mars",
                3389500,
                6.39e23,
                3.71
        ));

        planets.add(new Planet(
                "Moon",
                1737400,
                7.35e22,
                1.62
        ));

        return planets;
    }
}
