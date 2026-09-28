package com.gravitylaunchoptimizer;

public class TrajectoryPoint {
    private final double time;
    private final double x;
    private final double y;
    private final double gravity;

    public TrajectoryPoint(double time, double x, double y, double gravity) {
        this.time = time;
        this.x = x;
        this.y = y;
        this.gravity = gravity;
    }

    public double getTime() {
        return time;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getGravity() {
        return gravity;
    }
}
