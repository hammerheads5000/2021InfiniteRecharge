// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutoCommands2021.GalacticSearch;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.AimHorizontalSub;
import frc.robot.subsystems.BallVisionSub;

public class BallVisionCommand extends CommandBase {
  /** Creates a new BallVisionCommand. */
  private final AimHorizontalSub aimHorizontal;
  private final BallVisionSub ballVision;

  public BallVisionCommand(AimHorizontalSub aimHorizontalSub, BallVisionSub ballVisionSub) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.aimHorizontal=aimHorizontalSub;
    this.ballVision = ballVisionSub;
    addRequirements(this.aimHorizontal);
    addRequirements(this.ballVision);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    this.aimHorizontal.m_TurnOnLimelight();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    this.aimHorizontal.m_TurnOffLimelight();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
