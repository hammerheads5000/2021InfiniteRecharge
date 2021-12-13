/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.OldAutoCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.AutoCommands2021.AutoDriveCommand;
//import frc.robot.Constants;
import frc.robot.commands.ShooterCommands.InitializeShooterCommand;
import frc.robot.subsystems.IntakeWheelsSub;
import frc.robot.subsystems.AimHorizontalSub;
import frc.robot.subsystems.AimVerticalSub;
import frc.robot.subsystems.RaiseLowerIntakeSub;
import frc.robot.subsystems.ShooterSub;
import frc.robot.subsystems.IntakeHorizontalSub;
import frc.robot.subsystems.IntakeVerticalSub;
import frc.robot.subsystems.AutoDriveSub;
import frc.robot.subsystems.DrivetrainSub;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class AutonomousCommandGroup extends SequentialCommandGroup {
  /**
   * Creates a new AutonomousCommandGroup.
   */
  public AutonomousCommandGroup(AimHorizontalSub m_aimHorizontal, AimVerticalSub m_aimVertical,
                                ShooterSub m_shooterSub,
                                IntakeHorizontalSub m_intakeHorizontalSub, IntakeVerticalSub m_IntakeVerticalSub,
                                IntakeWheelsSub m_iIntakeWheelsSub, RaiseLowerIntakeSub m_raiseLowerIntakeSub,
                                AutoDriveSub drive,
                                DrivetrainSub m_drivetrainSub) {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    super(      
      new InitializeShooterCommand(m_aimHorizontal),
      new AutoAimCommand(m_aimHorizontal, m_aimVertical),
      new AutoShootFuelCellsCommandGroup(m_shooterSub, m_intakeHorizontalSub, m_IntakeVerticalSub),
      new AutoDriveCommand(drive, m_drivetrainSub, Constants.AUTO_DRIVE_FORWARD_POINT)
     
      /*new AutoTurnLeftOrRightCommand(drive, m_drivetrainSub, Constants.LEFT_AUTO_TURN_LEFT_DISTANCE),
      new DropIntakeCommand(m_iIntakeWheelsSub, m_raiseLowerIntakeSub),
      new AutoForwardsOrBackwardsCommand(drive, m_drivetrainSub, Constants.LEFT_AUTO_FORWARDS_BASE_LINE_DISTANCE),
      new AutoTurnLeftOrRightCommand(drive, m_drivetrainSub, Constants.LEFT_AUTO_TURN_RIGHT_DISTANCE),
      new AutoIntakeFuelCellsCommandGroup(drive, m_iIntakeWheelsSub, m_intakeHorizontalSub, m_IntakeVerticalSub, m_drivetrainSub),
      new AutoForwardsOrBackwardsCommand(drive, m_drivetrainSub, Constants.LEFT_AUTO_BACKWARDS_FUEL_CELLS_DISTANCE),
      new AutoTurnLeftOrRightCommand(drive, m_drivetrainSub, Constants.LEFT_AUTO_TURN_LEFT_DISTANCE),
      new AutoForwardsOrBackwardsCommand(drive, m_drivetrainSub, Constants.LEFT_AUTO_BACKWARDS_BASE_LINE_DISTANCE),
      new AutoTurnLeftOrRightCommand(drive, m_drivetrainSub, Constants.LEFT_AUTO_TURN_RIGHT_DISTANCE),
      new AutoAimCommand(m_aimHorizontal, m_aimVertical),
      new AutoShootFuelCellsCommandGroup(m_shooterSub, m_intakeHorizontalSub, m_IntakeVerticalSub)*/
    );
  }
}
