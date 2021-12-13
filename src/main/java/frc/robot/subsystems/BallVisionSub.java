// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.AutoConstants;
import java.lang.Math;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;


public class BallVisionSub extends SubsystemBase {
  /** Creates a new BallVision. */

  private double distance;

  public BallVisionSub() {

  }
// https://docs.limelightvision.io/en/latest/cs_estimating_distance.html
//turns out limelight doesn't directly give us distance to target, we have to do it ourself. 

  public void m_getDistance(){
    //THIS IS ALL GUESSWORK don't know how to do this
    double verticalAngle = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0.0);
    //^gets vertical offset of ball from 
    this.distance = AutoConstants.LIMELIGHT_HEIGHT / Math.tan(verticalAngle);//Math.tan does radians
    //see onenote for work
  }

  public void m_setActivePath(){
    AutoConstants.setActivePath(this.m_getIntendedPath());
  }

  public String m_getIntendedPath(){
    for(int i = 1; i <= AutoConstants.DATA.size(); i++){
      //parses through stored distances and checks them against current distance from sensor
      if(Math.abs(this.distance - AutoConstants.DATA.getEntry("PATH" + i, "START")) < AutoConstants.VISION_ERROR){
        return "PATH" + i;
        //returns the index of the distance that matches
      }
    }
    return "PATH1";
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
