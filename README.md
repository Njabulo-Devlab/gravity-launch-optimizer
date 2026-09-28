# GravityLaunchOptimizer V2

An educational aerospace trajectory simulation platform built with Java, Spring Boot and Thymeleaf.

## V2 focus: Variable Gravity

Version 2 upgrades the original constant-gravity model. Gravity is recalculated at every simulation step using:

g(h) = GM / (R + h)^2

where:
- G = universal gravitational constant
- M = planetary mass
- R = planetary radius
- h = current altitude above the surface

The simulator also records gravity as part of trajectory telemetry.

## Current features

- Earth, Mars and Moon models
- Initial altitude, velocity and launch angle
- Variable gravity throughout the flight
- Maximum altitude
- Horizontal range
- Flight time
- Trajectory data
- Gravity telemetry
- Interactive SVG trajectory graph
- Animated vehicle replay

## Important model limitation

This is an educational simulation, not an engineering-grade flight model. The current trajectory model is still a local 2D ballistic approximation and does not yet include atmospheric density, aerodynamic drag, planetary rotation, or full orbital mechanics.

## Run

1. Open the project in IntelliJ IDEA.
2. Use JDK 25.
3. Allow Maven to download dependencies.
4. Run:
   `GravityLaunchOptimizerApplication.java`
5. Open:
   `http://localhost:8080`

## Git

Suggested commit:

git add .
git commit -m "Upgrade physics engine to variable gravity"
git push
