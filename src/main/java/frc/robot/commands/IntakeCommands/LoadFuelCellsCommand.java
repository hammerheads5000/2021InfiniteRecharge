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

public class LoadFuelCellsCommand extends CommandBase {
  private final IntakeHorizontalSub m_intakeHorizontalSub;
  private final IntakeVerticalSub m_IntakeVerticalSub;
  private boolean secondIRSensor, thirdIRSensor, fourthIRSensor;
 
  /**
   * Creates a new LoadFuelCellsCommand.
   */
  public LoadFuelCellsCommand(IntakeHorizontalSub horizontalSubsystem, IntakeVerticalSub verticalSubsystem) {
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
    secondIRSensor = !m_intakeHorizontalSub.m_getSensor2();
    thirdIRSensor = !m_intakeHorizontalSub.m_getSensor3();
    fourthIRSensor = !m_intakeHorizontalSub.m_getSensor4();


    if(!secondIRSensor && !thirdIRSensor && !fourthIRSensor){
      m_intakeHorizontalSub.m_spinHorizontalMotorIn();
      m_IntakeVerticalSub.m_stopVerticalMotor();
    }
    else if (secondIRSensor && !thirdIRSensor && !fourthIRSensor){
      m_intakeHorizontalSub.m_stopHorizontalMotor();
      m_IntakeVerticalSub.m_spinVerticalMotorIn();
    }
    else if (secondIRSensor && fourthIRSensor){
      m_intakeHorizontalSub.m_stopHorizontalMotor();
      m_IntakeVerticalSub.m_spinVerticalMotorIn();
    }
    else if (thirdIRSensor && fourthIRSensor){
      m_intakeHorizontalSub.m_stopHorizontalMotor();
      m_IntakeVerticalSub.m_spinVerticalMotorIn();
    }
    else if(!secondIRSensor && !thirdIRSensor && fourthIRSensor){
      m_intakeHorizontalSub.m_spinHorizontalMotorIn();
      m_IntakeVerticalSub.m_stopVerticalMotor();
    }
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
