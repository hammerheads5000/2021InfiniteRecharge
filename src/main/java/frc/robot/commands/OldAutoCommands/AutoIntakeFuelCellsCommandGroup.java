/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.OldAutoCommands;


import frc.robot.commands.IntakeCommands.*;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.subsystems.IntakeWheelsSub;
import frc.robot.subsystems.AutoDriveSub;
import frc.robot.subsystems.IntakeHorizontalSub;
import frc.robot.subsystems.DrivetrainSub;
import frc.robot.subsystems.IntakeVerticalSub;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class AutoIntakeFuelCellsCommandGroup extends ParallelDeadlineGroup {
  /**
   * Creates a new AutoIntakeFuelCellsCommandGroup.
   */
  public AutoIntakeFuelCellsCommandGroup(AutoDriveSub drive, IntakeWheelsSub m_iIntakeWheelsSub,
                                        IntakeHorizontalSub m_intakeHorizontalSub, IntakeVerticalSub m_IntakeVerticalSub,
                                        DrivetrainSub m_drivetrainSub) {
    // Add your commands in the super() call.  Add the deadline first.
    super(
        new DriveForwardToFuelCellsCommandGroup(drive, m_drivetrainSub),
        new IntakeWheelsInCommand(m_iIntakeWheelsSub),
        new DefaultFunnelCommand(m_intakeHorizontalSub, m_IntakeVerticalSub)
    );
  }
}
