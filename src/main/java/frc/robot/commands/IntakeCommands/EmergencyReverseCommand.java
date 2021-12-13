/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.IntakeCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeHorizontalSub;
import frc.robot.subsystems.IntakeVerticalSub;

public class EmergencyReverseCommand extends CommandBase {
  private final IntakeHorizontalSub m_intakeHorizontalSub;
  private final IntakeVerticalSub m_IntakeVerticalSub;
  /**
   * Creates a new EmergencyReverseCommand.
   */
  public EmergencyReverseCommand(IntakeHorizontalSub horizontalSubsystem, IntakeVerticalSub verticalSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_intakeHorizontalSub = horizontalSubsystem;
    m_IntakeVerticalSub = verticalSubsystem;
    addRequirements(m_intakeHorizontalSub);
    addRequirements(m_IntakeVerticalSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_intakeHorizontalSub.m_spinHorizontalMotorOut();
    m_IntakeVerticalSub.m_spinVerticalMotorOut();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_intakeHorizontalSub.m_stopHorizontalMotor();
    m_IntakeVerticalSub.m_stopVerticalMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
