package com.gravitylaunchoptimizer;

import java.util.List;

public class SimulationResult {
    private final double maxHeight;
    private final double range;
    private final double flightTime;
    private final double initialGravity;
    private final double finalGravity;
    private final List<TrajectoryPoint> trajectory;

    public SimulationResult(double maxHeight, double range, double flightTime,
                            double initialGravity, double finalGravity,
                            List<TrajectoryPoint> trajectory) {
        this.maxHeight = maxHeight;
        this.range = range;
        this.flightTime = flightTime;
        this.initialGravity = initialGravity;
        this.finalGravity = finalGravity;
        this.trajectory = trajectory;
    }

    public double getMaxHeight() {
        return maxHeight;
    }

    public double getRange() {
        return range;
    }

    public double getFlightTime() {
        return flightTime;
    }

    public double getInitialGravity() {
        return initialGravity;
    }

    public double getFinalGravity() {
        return finalGravity;
    }

    public List<TrajectoryPoint> getTrajectory() {
        return trajectory;
    }
}
