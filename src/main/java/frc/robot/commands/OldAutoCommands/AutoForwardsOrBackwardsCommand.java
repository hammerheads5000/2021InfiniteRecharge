/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.OldAutoCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.AutoDriveSub;
import frc.robot.subsystems.DrivetrainSub;
import frc.robot.Constants;

public class AutoForwardsOrBackwardsCommand extends CommandBase {
  private final AutoDriveSub m_autoDrive;
  private final int m_distance;
  /**
   * Creates a new AutoForwardsOrBackwardsCommand.
   */
  public AutoForwardsOrBackwardsCommand(AutoDriveSub drive, DrivetrainSub m_drivetrainSub, int distance) {
    m_autoDrive = drive;
    m_distance = distance;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_autoDrive);
    addRequirements(m_drivetrainSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_autoDrive.m_zeroEncoder();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_autoDrive.m_driveForwardsOrBack(m_distance);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_autoDrive.m_stopMotors();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(Math.abs(Constants.AUTO_DRIVE_FORWARD_POINT - m_autoDrive.m_getPosition()) <= Constants.kERROR){
      return true;
    }
    else{
      return false;
    }
  }
}