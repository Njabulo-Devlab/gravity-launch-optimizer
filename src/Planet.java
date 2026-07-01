public class Planet {

    private String name;
        private double radius;
        private double mass;
        private double surfaceGravity;

        public Planet(String name, double radius, double mass, double surfaceGravity) {
            this.name = name;
            this.radius = radius;
            this.mass = mass;
            this.surfaceGravity = surfaceGravity;
        }

        public String getName() {
            return name;
        }

        public double getRadius() {
            return radius;
        }

        public double getMass() {
            return mass;
        }

        public double getSurfaceGravity() {
            return surfaceGravity;
        }
    }
