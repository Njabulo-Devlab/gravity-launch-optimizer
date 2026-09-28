package com.gravitylaunchoptimizer;
import java.util.ArrayList;import java.util.List;
public class GravityCalculator {
 private static final double DT=.05,MAX_TIME=3600,TRAJECTORY_SAMPLE_INTERVAL=.5;
 public SimulationResult simulateFlight(Planet planet,double initialHeight,double initialVelocity,double angleDegrees,double massKg,double cd,double area){
  if(massKg<=0||cd<0||area<0)throw new IllegalArgumentException("Mass must be > 0; Cd and area must be >= 0.");
  double a=Math.toRadians(angleDegrees),x=0,y=Math.max(0,initialHeight),vx=initialVelocity*Math.cos(a),vy=initialVelocity*Math.sin(a),t=0,last=-.5;
  double maxH=y,maxSpeed=Math.hypot(vx,vy),maxDrag=0,maxDragA=0; List<TrajectoryPoint> tr=new ArrayList<>();
  double initialG=planet.gravityAtAltitude(y);tr.add(sample(planet,t,x,y,vx,vy,0,massKg,cd,area));
  while(t<MAX_TIME){
   double h=Math.max(0,y),g=planet.gravityAtAltitude(h),rho=planet.atmosphericDensityAtAltitude(h),speed=Math.hypot(vx,vy);
   double drag=.5*rho*cd*area*speed*speed,dragA=drag/massKg;
   double dax=speed>0?-dragA*vx/speed:0,day=speed>0?-dragA*vy/speed:0;
   double ax=dax,ay=-g+day;
   vx+=ax*DT;vy+=ay*DT;x+=vx*DT;y+=vy*DT;t+=DT;
   maxH=Math.max(maxH,y);maxSpeed=Math.max(maxSpeed,Math.hypot(vx,vy));maxDrag=Math.max(maxDrag,drag);maxDragA=Math.max(maxDragA,dragA);
   if(t-last>=TRAJECTORY_SAMPLE_INTERVAL-1e-9){tr.add(sample(planet,t,x,Math.max(0,y),vx,vy,Math.hypot(ax,ay),massKg,cd,area));last=t;}
   if(y<=0&&t>0){y=0;tr.add(sample(planet,t,x,y,vx,vy,Math.hypot(ax,ay),massKg,cd,area));break;}
  }
  return new SimulationResult(maxH,x,t,initialG,planet.gravityAtAltitude(Math.max(0,y)),maxSpeed,maxDrag,maxDragA,tr);
 }
 private TrajectoryPoint sample(Planet p,double t,double x,double y,double vx,double vy,double acc,double m,double cd,double area){
  y=Math.max(0,y);double speed=Math.hypot(vx,vy),g=p.gravityAtAltitude(y),rho=p.atmosphericDensityAtAltitude(y),drag=.5*rho*cd*area*speed*speed;
  return new TrajectoryPoint(t,x,y,speed,acc,g,rho,drag,drag/m);
 }
}