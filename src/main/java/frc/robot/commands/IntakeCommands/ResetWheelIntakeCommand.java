/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.IntakeCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.IntakeWheelsSub;
import frc.robot.subsystems.RaiseLowerIntakeSub;
import edu.wpi.first.wpilibj.Timer;

public class ResetWheelIntakeCommand extends CommandBase {
  private final IntakeWheelsSub m_iIntakeWheelsSub;
  private final RaiseLowerIntakeSub m_raiseLowerIntakeSub;
  private final Timer timer = new Timer();
  private double tempTimer;

  /**
   * Creates a new ResetWheelIntakeCommand.
   */
  public ResetWheelIntakeCommand(IntakeWheelsSub intakeWheelsSubsystem, RaiseLowerIntakeSub dropIntakeSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_iIntakeWheelsSub = intakeWheelsSubsystem;
    m_raiseLowerIntakeSub = dropIntakeSubsystem;
    addRequirements(m_iIntakeWheelsSub);
    addRequirements(m_raiseLowerIntakeSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_iIntakeWheelsSub.m_stopWheels();
    timer.start();
    tempTimer = timer.get();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_raiseLowerIntakeSub.m_raiseIntake();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_raiseLowerIntakeSub.m_stopMovingIntake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(timer.get() >= tempTimer + Constants.TIME_FOR_RAISING_INTAKE){
      return true;
    }else{
      return false;
    }
  }
}
