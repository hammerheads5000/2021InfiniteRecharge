/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.OldAutoCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.IntakeCommands.DelayCommand;
import frc.robot.subsystems.IntakeHorizontalSub;
import frc.robot.subsystems.IntakeVerticalSub;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class AutoLoadFuelCellsCommandGroup extends SequentialCommandGroup {
  /**
   * Creates a new AutoLoadFuelCellsCommandGroup.
   */
  public AutoLoadFuelCellsCommandGroup(IntakeHorizontalSub m_intakeHorizontalSub, IntakeVerticalSub m_IntakeVerticalSub) {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    super(
      new DelayCommand(Constants.DELAY_BEFORE_LOADING_FUEL_CELLS),
      new AutoFirstThreeFuelCellsCommandGroup(m_intakeHorizontalSub, m_IntakeVerticalSub),
      new AutoLastTwoFuelCellsCommandGroup(m_IntakeVerticalSub)
    );
  }
}
