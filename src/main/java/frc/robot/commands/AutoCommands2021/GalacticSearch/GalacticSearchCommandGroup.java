// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutoCommands2021.GalacticSearch;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.AutoConstants;
import frc.robot.commands.IntakeCommands.DropIntakeCommand;
import frc.robot.commands.IntakeCommands.IntakeWheelsInCommand;
import frc.robot.commands.AutoCommands2021.*;
import frc.robot.subsystems.*;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class GalacticSearchCommandGroup extends SequentialCommandGroup {
  /** Creates a new GalacticSearchCommandGroup. */
  public GalacticSearchCommandGroup(IntakeWheelsSub intakeWheelsSub, RaiseLowerIntakeSub dropIntakeSubsystem, 
    AutoDriveSub autoDrive, DrivetrainSub drivetrain, AimHorizontalSub aimHorizontalSub, BallVisionSub ballVisionSub) {
    
    super(
          new BallVisionCommand(aimHorizontalSub, ballVisionSub),
          new DropIntakeCommand(intakeWheelsSub, dropIntakeSubsystem),
          new IntakeWheelsInCommand(intakeWheelsSub),
          new AutoDriveCommand(autoDrive, drivetrain, AutoConstants.DATA.getEntry("ACTIVE", "DISTANCE1")),
          new AutoTurnCommand(autoDrive, drivetrain, AutoConstants.DATA.getEntry("ACTIVE", "TURN1")),
          new AutoDriveCommand(autoDrive, drivetrain, AutoConstants.DATA.getEntry("ACTIVE", "DISTANCE2")),
          new AutoTurnCommand(autoDrive, drivetrain, AutoConstants.DATA.getEntry("ACTIVE", "TURN2")),
          new AutoDriveCommand(autoDrive, drivetrain, AutoConstants.DATA.getEntry("ACTIVE", "DISTANCE3")),
          new AutoTurnCommand(autoDrive, drivetrain, AutoConstants.DATA.getEntry("ACTIVE", "TURN3")),
          new AutoDriveCommand(autoDrive, drivetrain, AutoConstants.DATA.getEntry("ACTIVE", "DISTANCE4"))
    );

  }
}
