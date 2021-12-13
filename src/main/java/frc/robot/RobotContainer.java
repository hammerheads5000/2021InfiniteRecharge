/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

/*

*/
package frc.robot;

import frc.robot.subsystems.*;
//import edu.wpi.first.wpilibj.GenericHID;
//import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.*;
//import frc.robot.commands.AutoCommands2021.*;
import frc.robot.commands.IntakeCommands.*;
import frc.robot.commands.OldAutoCommands.*;
import frc.robot.commands.ShooterCommands.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
//import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
 
/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  private final DrivetrainSub m_drivetrainSub = new DrivetrainSub();
  private final RaiseLowerIntakeSub m_raiseLowerIntakeSub = new RaiseLowerIntakeSub();
  private final IntakeWheelsSub m_aFineAdditionToMyCollection = new IntakeWheelsSub();

  private final IntakeVerticalSub m_IntakeVerticalSub = new IntakeVerticalSub();
  private final IntakeHorizontalSub m_intakeHorizontalSub = new IntakeHorizontalSub();

  private final ShooterSub m_shooterSub = new ShooterSub();
  private final AimHorizontalSub m_aimHorizontal = new AimHorizontalSub();
  private final AimVerticalSub m_aimVertical = new AimVerticalSub();

  //private final DropIntakeCommand m_dropIntakeCommand = new DropIntakeCommand(m_aFineAdditionToMyCollection, m_raiseLowerIntakeSub);
  private final IntakeWheelsOutCommand m_intakeWheelsOutCommand = new IntakeWheelsOutCommand(m_aFineAdditionToMyCollection);
  private final ResetWheelIntakeCommand m_resetWheelIntakeCommand = new ResetWheelIntakeCommand(m_aFineAdditionToMyCollection, m_raiseLowerIntakeSub);
  private final IntakeWheelsInCommand m_intakeWheelsInCommand = new IntakeWheelsInCommand(m_aFineAdditionToMyCollection);

  private final VerticalOverrideCommand m_verticalOverrideCommand = new VerticalOverrideCommand(m_aimVertical);

  private final LoadFuelCellsCommand m_loadFuelCellsCommand = new LoadFuelCellsCommand(m_intakeHorizontalSub, m_IntakeVerticalSub);
  private final EmergencyReverseCommand m_emergencyReverseCommand = new EmergencyReverseCommand(m_intakeHorizontalSub, m_IntakeVerticalSub);
  private final DefaultFunnelCommand m_defaultFunnelCommand = new DefaultFunnelCommand(m_intakeHorizontalSub, m_IntakeVerticalSub);
  private final TurnVerticalCommand m_turnVerticalCommand = new TurnVerticalCommand(m_IntakeVerticalSub);

  private final DropIntakeCommandGroup m_dropIntakeCommandGroup = new DropIntakeCommandGroup(m_aFineAdditionToMyCollection, m_raiseLowerIntakeSub);

  private final ShooterCommand m_shooterCommand = new ShooterCommand(m_shooterSub);
  private final TurretCommand m_turretCommand = new TurretCommand(m_aimHorizontal, m_aimVertical);

  private final Joystick driveJoystick = new Joystick(Constants.DRIVE_JOYSTICK_PORT);

  private final Joystick buttonsController = new Joystick(Constants.BUTTONS_CONTROLLER_PORT);

  public void getRawAxis(Joystick driveJoystick){
    SmartDashboard.putNumber("AxisOne", driveJoystick.getRawAxis(1));
  }

  //private final SendableChooser<Joystick> driveChooser = new SendableChooser<Joystick>();
  //private final SendableChooser<Joystick> buttonsChooser = new SendableChooser<Joystick>();

  private final AutoDriveSub m_autoDrive = new AutoDriveSub();

  //private final AutoDriveTest m_autoDriveTest = new AutoDriveTest(m_autoDrive, m_drivetrainSub);

  private final AutonomousCommandGroup m_autonomousCommandGroup = new AutonomousCommandGroup(m_aimHorizontal, m_aimVertical, m_shooterSub, m_intakeHorizontalSub, m_IntakeVerticalSub, m_aFineAdditionToMyCollection, m_raiseLowerIntakeSub, m_autoDrive, m_drivetrainSub);

 
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {

    configureButtonBindings();
 
    m_drivetrainSub.setDefaultCommand(
      new DriveCommand(m_drivetrainSub, 
      () -> -driveJoystick.getRawAxis(1), 
      () -> -driveJoystick.getRawAxis(2),
      () -> driveJoystick.getRawAxis(3)));

    m_intakeHorizontalSub.setDefaultCommand(m_defaultFunnelCommand);
    m_IntakeVerticalSub.setDefaultCommand(m_defaultFunnelCommand);
  }
 
  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

      JoystickButton dropIntakeButton = new JoystickButton(driveJoystick, Constants.DROP_INTAKE_JOYSTICK_BUTTON);
      dropIntakeButton.whileActiveOnce(m_dropIntakeCommandGroup, Constants.INTERRUPTIBLE).whenInactive(m_resetWheelIntakeCommand, Constants.INTERRUPTIBLE);

      Trigger intakeOutTrigger = new JoystickButton(driveJoystick, Constants.INTAKE_OUT_JOYSTICK_BUTTON)
      .and(new JoystickButton(driveJoystick, Constants.DROP_INTAKE_JOYSTICK_BUTTON));
      intakeOutTrigger.whileActiveContinuous(m_intakeWheelsOutCommand, Constants.INTERRUPTIBLE)
        .whenInactive(m_intakeWheelsInCommand, Constants.INTERRUPTIBLE);
    

      JoystickButton verticalOverrideButton = new JoystickButton(buttonsController, Constants.SERVO_OVERRIDE_BUTTON);
      verticalOverrideButton.whileActiveOnce(m_verticalOverrideCommand, Constants.INTERRUPTIBLE);
      
      JoystickButton loadFuelCellsButton = new JoystickButton(buttonsController, Constants.LOAD_FUEL_CELLS_CONTROLLER_BUTTON);
      loadFuelCellsButton.whileActiveOnce(m_loadFuelCellsCommand, Constants.INTERRUPTIBLE);  

      JoystickButton emergencyReverseButton = new JoystickButton(buttonsController, Constants.EMERGENCY_REVERSE_CONTROLLER_BUTTON);
      emergencyReverseButton.whileActiveContinuous(m_emergencyReverseCommand, Constants.INTERRUPTIBLE);

      JoystickButton turnVerticalButton = new JoystickButton(buttonsController, Constants.TURN_VERTICAL_CONTROLLER_BUTTON);
      turnVerticalButton.whileActiveContinuous(m_turnVerticalCommand, Constants.NOT_INTERRUPTIBLE);
    
      JoystickButton fireBallTrigger = new JoystickButton(buttonsController, Constants.KOBE_CONTROLLER_BUTTON);
      fireBallTrigger.whileActiveContinuous(m_shooterCommand, Constants.INTERRUPTIBLE);
      
      JoystickButton aimTrigger = new JoystickButton(buttonsController, Constants.AIM_CONTROLLER_BUTTON);
      aimTrigger.whileActiveContinuous(m_turretCommand, Constants.INTERRUPTIBLE);

  }
 
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return m_autonomousCommandGroup;
  }
}

