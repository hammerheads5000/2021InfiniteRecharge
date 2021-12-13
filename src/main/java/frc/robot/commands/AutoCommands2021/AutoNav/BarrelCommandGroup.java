// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutoCommands2021.AutoNav;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.AutoConstants;
import frc.robot.commands.AutoCommands2021.*;
import frc.robot.subsystems.AutoDriveSub;
import frc.robot.subsystems.DrivetrainSub;


// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class BarrelCommandGroup extends SequentialCommandGroup {


  /** Creates a new BarrelCommandGroup. */

  public BarrelCommandGroup(AutoDriveSub autoDrive, DrivetrainSub drivetrain) {

    super(
          new AutoDriveCommand(autoDrive, drivetrain, AutoConstants.BARREL_FIRST_DISTANCE),
          new AutoTurnCommand(autoDrive, drivetrain, AutoConstants.NINETY_DEGREES)

    );

  }
}
