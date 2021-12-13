/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.ShooterCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.AimHorizontalSub;
import frc.robot.Constants;

public class InitializeShooterCommand extends CommandBase {
  private final AimHorizontalSub m_aimHorizontal;
  private double temp;

  /**
   * Creates a new InitializeShooterCommand.
   */
  public InitializeShooterCommand(AimHorizontalSub turnHorizontal) {
    m_aimHorizontal = turnHorizontal;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_aimHorizontal);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    temp = Timer.getFPGATimestamp();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_aimHorizontal.m_initializeShooter();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_aimHorizontal.m_stopTurning();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(Timer.getFPGATimestamp() >= temp + Constants.TIME_TO_INITIALIZE_SHOOTER){
      return true;
    }else{
    return false;
    }
  }
}
