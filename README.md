# GravityLaunchOptimizer V2.1

## Mission: Atmosphere & Aerodynamic Drag

V2.1 extends the variable-gravity engine with a simple atmospheric model and aerodynamic drag.

Atmospheric density:
rho(h) = rho0 * exp(-h / H)

Drag force:
Fd = 0.5 * rho * Cd * A * v^2

Drag acceleration:
ad = Fd / m

Drag acts opposite to the velocity vector and therefore affects horizontal and vertical velocity.

### Vehicle parameters
- Mass (kg)
- Drag coefficient Cd
- Reference area (m²)

Defaults: 100 kg, Cd 0.5, area 1.0 m².

### Telemetry
Time, horizontal position, altitude, speed, acceleration magnitude, gravity, air density, drag force, and drag acceleration.

### Limitation
Educational local 2D model. It does not yet include wind, temperature-layer atmosphere, Mach-dependent Cd, lift, planetary rotation, or full orbital mechanics.

Run `GravityLaunchOptimizerApplication.java` with JDK 25, then open http://localhost:8080.

Suggested Git commit:
`git add .`
`git commit -m "Add atmosphere and aerodynamic drag"`
`git push`
