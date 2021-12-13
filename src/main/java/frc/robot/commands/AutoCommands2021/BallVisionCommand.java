// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutoCommands2021;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BallVisionSub;


public class BallVisionCommand extends CommandBase {
  /** Creates a new BallVisionCommand. */

  private BallVisionSub ballVisionSub;
  public BallVisionCommand(BallVisionSub ballVisionSub) {
    this.ballVisionSub = ballVisionSub;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(this.ballVisionSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    ballVisionSub.m_getDistance(); //don't know how to do this
    //also, we might just put that in the initialize or something and have nothing here, I don't know
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    this.ballVisionSub.m_setActivePath();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;//going to need to change this
  }
}
