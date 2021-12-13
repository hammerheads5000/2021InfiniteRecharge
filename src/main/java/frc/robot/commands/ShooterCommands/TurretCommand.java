/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.ShooterCommands;

//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.AimHorizontalSub;
import frc.robot.subsystems.AimVerticalSub;

public class TurretCommand extends CommandBase {
  /**
   * Creates a new TurretCommand.
   */
  private final AimHorizontalSub m_aimHorizontal;
  private final AimVerticalSub m_aimVertical;

  public TurretCommand(AimHorizontalSub turnHorizontal, AimVerticalSub turnVertical) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_aimHorizontal = turnHorizontal;
    m_aimVertical = turnVertical;
    addRequirements(m_aimHorizontal);
    addRequirements(m_aimVertical);

    m_aimHorizontal.m_TurnOffLimelight();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_aimHorizontal.m_TurnOnLimelight();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() { 
    m_aimHorizontal.m_aimHorizontal();
    m_aimVertical.m_aimVertical();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
    m_aimHorizontal.m_stopTurning();
    m_aimHorizontal.m_TurnOffLimelight();
    m_aimVertical.m_stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false; 
  }
}
