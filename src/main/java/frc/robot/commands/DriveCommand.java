/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
 
package frc.robot.commands;
 
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSub;
import java.util.function.DoubleSupplier;
 
public class DriveCommand extends CommandBase {
  private final DrivetrainSub m_drivetrain;
  private DoubleSupplier m_forward;
  private DoubleSupplier m_rotation;
  private DoubleSupplier m_throttle;
 
  public DriveCommand(DrivetrainSub subsystem, DoubleSupplier forward, DoubleSupplier twist, DoubleSupplier throttle) {
    m_drivetrain = subsystem;
    m_forward = forward;
    m_rotation = twist;
    m_throttle = throttle;
    
    addRequirements(m_drivetrain);
  }
 
  @Override
  public void execute() {
    m_drivetrain.m_arcadeDrive(m_forward.getAsDouble(), m_rotation.getAsDouble(), (-m_throttle.getAsDouble()+1)/2);
  }
}

