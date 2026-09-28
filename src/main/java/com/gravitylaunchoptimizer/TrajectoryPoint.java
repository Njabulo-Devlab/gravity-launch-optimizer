package com.gravitylaunchoptimizer;
public class TrajectoryPoint {
 private final double time,x,y,speed,acceleration,gravity,airDensity,dragForce,dragAcceleration;
 public TrajectoryPoint(double time,double x,double y,double speed,double acceleration,double gravity,double airDensity,double dragForce,double dragAcceleration){this.time=time;this.x=x;this.y=y;this.speed=speed;this.acceleration=acceleration;this.gravity=gravity;this.airDensity=airDensity;this.dragForce=dragForce;this.dragAcceleration=dragAcceleration;}
 public double getTime(){return time;} public double getX(){return x;} public double getY(){return y;} public double getSpeed(){return speed;} public double getAcceleration(){return acceleration;} public double getGravity(){return gravity;} public double getAirDensity(){return airDensity;} public double getDragForce(){return dragForce;} public double getDragAcceleration(){return dragAcceleration;}
}