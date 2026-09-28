package com.gravitylaunchoptimizer;
public class Planet {
 private final String name; private final double radiusMeters,massKg,seaLevelDensityKgPerM3,atmosphericScaleHeightMeters;
 public Planet(String name,double radiusMeters,double massKg,double density,double scaleHeight){this.name=name;this.radiusMeters=radiusMeters;this.massKg=massKg;this.seaLevelDensityKgPerM3=density;this.atmosphericScaleHeightMeters=scaleHeight;}
 public String getName(){return name;} public double getRadiusMeters(){return radiusMeters;} public double getMassKg(){return massKg;}
 public double gravityAtAltitude(double h){h=Math.max(0,h); double G=6.67430e-11,r=radiusMeters+h;return G*massKg/(r*r);}
 public double atmosphericDensityAtAltitude(double h){h=Math.max(0,h);return seaLevelDensityKgPerM3*Math.exp(-h/atmosphericScaleHeightMeters);}
}