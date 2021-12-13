/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.OldAutoCommands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.Constants;
import frc.robot.commands.IntakeCommands.DelayCommand;
import frc.robot.commands.IntakeCommands.TurnVerticalCommand;
import frc.robot.subsystems.IntakeVerticalSub;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class AutoLastTwoFuelCellsCommandGroup extends ParallelDeadlineGroup {
  /**
   * Creates a new AutoLastTwoFuelCellsCommandGroup.
   */
  public AutoLastTwoFuelCellsCommandGroup(IntakeVerticalSub m_IntakeVerticalSub) {
    // Add your commands in the super() call.  Add the deadline first.
    super(
        new DelayCommand(Constants.TIME_TO_LOAD_LAST_TWO_FUEL_CELLS),
        new TurnVerticalCommand(m_IntakeVerticalSub)
    );
  }
}
