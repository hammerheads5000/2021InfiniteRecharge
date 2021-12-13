// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutoCommands2021.AutoNav;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.AutoConstants;
import frc.robot.commands.AutoCommands2021.AutoDriveCommand;
import frc.robot.commands.AutoCommands2021.AutoTurnCommand;
import frc.robot.subsystems.AutoDriveSub;
import frc.robot.subsystems.DrivetrainSub;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class BounceCommandGroup extends SequentialCommandGroup {
  /** Creates a new BounceCommandGroup. */
  public BounceCommandGroup(AutoDriveSub m_autoDrive, DrivetrainSub m_drivetrainSub) {
    super(
      new AutoDriveCommand(m_autoDrive, m_drivetrainSub, AutoConstants.BOUNCE_FIRST_DISTANCE),
      new AutoTurnCommand(m_autoDrive, m_drivetrainSub, AutoConstants.BOUNCE_FIRST_TURN),
      new AutoDriveCommand(m_autoDrive, m_drivetrainSub, AutoConstants.BOUNCE_SECOND_DISTANCE), 
      new AutoTurnCommand(m_autoDrive, m_drivetrainSub, AutoConstants.BOUNCE_SECOND_TURN),
      new AutoDriveCommand(m_autoDrive, m_drivetrainSub, AutoConstants.BOUNCE_THIRD_DISTANCE),
      new AutoTurnCommand(m_autoDrive, m_drivetrainSub, AutoConstants.BOUNCE_THIRD_TURN),
      new AutoDriveCommand(m_autoDrive, m_drivetrainSub, AutoConstants.BOUNCE_FOURTH_DISTANCE),
      new AutoTurnCommand(m_autoDrive, m_drivetrainSub, AutoConstants.BOUNCE_FOURTH_TURN),
      new AutoDriveCommand(m_autoDrive, m_drivetrainSub, AutoConstants.BOUNCE_FIFTH_DISTANCE),
      new AutoTurnCommand(m_autoDrive, m_drivetrainSub, AutoConstants.BOUNCE_FIFTH_TURN),
      new AutoDriveCommand(m_autoDrive, m_drivetrainSub, AutoConstants.BOUNCE_SIXTH_DISTANCE),
      new AutoTurnCommand(m_autoDrive, m_drivetrainSub, AutoConstants.BOUNCE_SIXTH_TURN),
      new AutoDriveCommand(m_autoDrive, m_drivetrainSub, AutoConstants.BOUNCE_SEVENTH_DISTANCE),
      new AutoTurnCommand(m_autoDrive, m_drivetrainSub, AutoConstants.BOUNCE_SEVENTH_TURN),
      new AutoDriveCommand(m_autoDrive, m_drivetrainSub, AutoConstants.BOUNCE_EIGHTH_DISTANCE)
    );
  }
}
