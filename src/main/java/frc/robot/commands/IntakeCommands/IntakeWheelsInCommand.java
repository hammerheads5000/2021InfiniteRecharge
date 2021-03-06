/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.IntakeCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeWheelsSub;

public class IntakeWheelsInCommand extends CommandBase {
  private final IntakeWheelsSub m_iIntakeWheelsSub;

  /**
   * Creates a new IntakeWheelsInCommand.
   */
  public IntakeWheelsInCommand(IntakeWheelsSub intakeWheelsSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_iIntakeWheelsSub = intakeWheelsSubsystem;
    addRequirements(m_iIntakeWheelsSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_iIntakeWheelsSub.m_spinWheelsIn();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
