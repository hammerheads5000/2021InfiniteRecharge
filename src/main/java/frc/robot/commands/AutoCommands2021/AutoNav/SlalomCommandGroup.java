// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutoCommands2021.AutoNav;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.AutoCommands2021.AutoTurnCommand;
import frc.robot.commands.AutoCommands2021.AutoDriveCommand;
import frc.robot.subsystems.AutoDriveSub;
import frc.robot.subsystems.DrivetrainSub;
import frc.robot.AutoConstants;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class SlalomCommandGroup extends SequentialCommandGroup {
  
  /** Creates a new SlalomCommandGroup. */
  public SlalomCommandGroup(AutoDriveSub m_autoDrive, DrivetrainSub m_drivetrainSub) {
    super(
      new AutoDriveCommand(m_autoDrive, m_drivetrainSub, AutoConstants.SLALOM_FIRST_DISTANCE),
      new AutoDriveCommand(m_autoDrive, m_drivetrainSub, AutoConstants.SLALOM_STOP),
      new AutoTurnCommand(m_autoDrive, m_drivetrainSub, AutoConstants.SLALOM_FIRST_ROTATION),
      new AutoDriveCommand(m_autoDrive, m_drivetrainSub, AutoConstants.SLALOM_DRIVE_STRAIGHT),
      new AutoDriveCommand(m_autoDrive, m_drivetrainSub, AutoConstants.SLALOM_STOP),
      new AutoTurnCommand(m_autoDrive, m_drivetrainSub, AutoConstants.SLALOM_SECOND_ROTATION),
      new AutoDriveCommand(m_autoDrive, m_drivetrainSub, AutoConstants.SLALOM_DRIVE_STRAIGHT),
      new AutoDriveCommand(m_autoDrive, m_drivetrainSub, AutoConstants.SLALOM_STOP),
      new AutoTurnCommand(m_autoDrive, m_drivetrainSub ,AutoConstants.SLALOM_THIRD_ROTATION),
      new AutoDriveCommand(m_autoDrive, m_drivetrainSub, AutoConstants.SLALOM_DRIVE_STRAIGHT),
      new AutoDriveCommand(m_autoDrive, m_drivetrainSub, AutoConstants.SLALOM_STOP),
      new AutoTurnCommand(m_autoDrive, m_drivetrainSub ,AutoConstants.SLALOM_FOURTH_ROTATION),
      new AutoDriveCommand(m_autoDrive, m_drivetrainSub, AutoConstants.SLALOM_DRIVE_CIRCLE_ONE),
      new AutoDriveCommand(m_autoDrive, m_drivetrainSub, AutoConstants.SLALOM_STOP),
      new AutoTurnCommand(m_autoDrive, m_drivetrainSub, AutoConstants.SLALOM_FIFTH_ROTATION),
      new AutoDriveCommand(m_autoDrive, m_drivetrainSub, AutoConstants.SLALOM_DRIVE_CIRCLE_TWO),
      new AutoDriveCommand(m_autoDrive, m_drivetrainSub, AutoConstants.SLALOM_STOP),
      new AutoTurnCommand(m_autoDrive, m_drivetrainSub, AutoConstants.SLALOM_SIXTH_ROTATION),
      new AutoDriveCommand(m_autoDrive, m_drivetrainSub, AutoConstants.SLALOM_DRIVE_CIRCLE_THREE),
      new AutoDriveCommand(m_autoDrive, m_drivetrainSub, AutoConstants.SLALOM_STOP),
      new AutoTurnCommand(m_autoDrive, m_drivetrainSub, AutoConstants.SLALOM_SEVENTH_ROTATION),
      new AutoDriveCommand(m_autoDrive, m_drivetrainSub, AutoConstants.SLALOM_DRIVE_CIRCLE_FOUR),
      new AutoDriveCommand(m_autoDrive, m_drivetrainSub, AutoConstants.SLALOM_STOP),
      new AutoTurnCommand(m_autoDrive, m_drivetrainSub, AutoConstants.SLALOM_EIGTH_ROTATION),
      new AutoDriveCommand(m_autoDrive, m_drivetrainSub, AutoConstants.SLALOM_DRIVE_STRAIGHT),
      new AutoDriveCommand(m_autoDrive, m_drivetrainSub, AutoConstants.SLALOM_STOP),
      new AutoTurnCommand(m_autoDrive, m_drivetrainSub, AutoConstants.SLALOM_NINTH_ROTATION),
      new AutoDriveCommand(m_autoDrive, m_drivetrainSub, AutoConstants.SLALOM_DRIVE_TO_END),
      new AutoDriveCommand(m_autoDrive, m_drivetrainSub, AutoConstants.SLALOM_STOP)
    ) ;
  }
}
