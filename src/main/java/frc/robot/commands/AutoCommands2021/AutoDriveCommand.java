/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.AutoCommands2021;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.AutoDriveSub;
import frc.robot.subsystems.DrivetrainSub;

public class AutoDriveCommand extends CommandBase {
  
  private final AutoDriveSub m_autoDrive;
  private int distance;
  /**
   * Creates a new AutoDriveTest.
   */

  public AutoDriveCommand(AutoDriveSub autoDrive, DrivetrainSub drivetrain, int distance) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_autoDrive = autoDrive;
    this.distance = distance;
    addRequirements(m_autoDrive);
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_autoDrive.m_zeroEncoder();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_autoDrive.m_driveForwardsOrBack(this.distance);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_autoDrive.m_stopMotors();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(Math.abs(this.distance - m_autoDrive.m_getPosition()) <= Constants.kERROR){
      return true;
    }
    else{
      return false;
    }
  }
}
