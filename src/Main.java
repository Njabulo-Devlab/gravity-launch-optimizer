public class Main {

    public static void main(String[] args) {

        for (Planet planet : PlanetDatabase.getPlanets()) {

            System.out.println(
                    planet.getName() +
                            " Gravity: " +
                            planet.getSurfaceGravity()
            );
        }
    }
}