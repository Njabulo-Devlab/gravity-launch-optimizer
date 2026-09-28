package com.gravitylaunchoptimizer;

import java.util.ArrayList;
import java.util.List;

public class GravityCalculator {

    private static final double DT = 0.1;
    private static final double MAX_TIME = 3600.0;
    private static final double TRAJECTORY_SAMPLE_INTERVAL = 0.5;

    public SimulationResult simulateFlight(
            Planet planet,
            double initialHeight,
            double initialVelocity,
            double angleDegrees) {

        double angle = Math.toRadians(angleDegrees);

        double x = 0.0;
        double y = Math.max(0.0, initialHeight);

        double vx = initialVelocity * Math.cos(angle);
        double vy = initialVelocity * Math.sin(angle);

        double time = 0.0;
        double maxHeight = y;
        double lastSampleTime = -TRAJECTORY_SAMPLE_INTERVAL;

        List<TrajectoryPoint> trajectory = new ArrayList<>();

        double initialGravity = planet.gravityAtAltitude(y);
        trajectory.add(new TrajectoryPoint(time, x, y, initialGravity));
        lastSampleTime = time;

        while (time < MAX_TIME) {
            double currentGravity = planet.gravityAtAltitude(y);

            // Local 2D ballistic model:
            // gravity acts vertically downward while its magnitude
            // changes with the vehicle's current altitude.
            vy -= currentGravity * DT;

            x += vx * DT;
            y += vy * DT;
            time += DT;

            if (y > maxHeight) {
                maxHeight = y;
            }

            if (time - lastSampleTime >= TRAJECTORY_SAMPLE_INTERVAL - 1e-9) {
                double gravity = planet.gravityAtAltitude(Math.max(0.0, y));
                trajectory.add(new TrajectoryPoint(time, x, Math.max(0.0, y), gravity));
                lastSampleTime = time;
            }

            if (y <= 0.0 && time > 0.0) {
                y = 0.0;
                trajectory.add(new TrajectoryPoint(
                        time, x, y, planet.gravityAtAltitude(0.0)));
                break;
            }
        }

        double finalGravity = planet.gravityAtAltitude(Math.max(0.0, y));

        return new SimulationResult(
                maxHeight,
                x,
                time,
                initialGravity,
                finalGravity,
                trajectory
        );
    }
}
