
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.AimVerticalSub;

public class VerticalOverrideCommand extends CommandBase {
  private final AimVerticalSub m_aimVertical;
  /** Creates a new VerticalOverrideCommand. */
  public VerticalOverrideCommand(AimVerticalSub aimVerticalSub) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_aimVertical = aimVerticalSub;
    addRequirements(m_aimVertical);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_aimVertical.m_override();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
