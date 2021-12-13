/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.OldAutoCommands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.commands.ShooterCommands.ShooterCommand;
import frc.robot.subsystems.ShooterSub;
import frc.robot.subsystems.IntakeHorizontalSub;
import frc.robot.subsystems.IntakeVerticalSub;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class AutoShootFuelCellsCommandGroup extends ParallelDeadlineGroup {
  /**
   * Creates a new AutoShootFuelCellsCommandGroup.
   */
  public AutoShootFuelCellsCommandGroup(ShooterSub m_shooterSub, IntakeHorizontalSub m_intakeHorizontalSub, IntakeVerticalSub m_IntakeVerticalSub) {
    // Add your commands in the super() call.  Add the deadline first.
    super(
        new AutoLoadFuelCellsCommandGroup(m_intakeHorizontalSub, m_IntakeVerticalSub),
        new ShooterCommand(m_shooterSub)
    );
  }
}
