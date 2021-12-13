/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

//import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
//import com.ctre.phoenix.motorcontrol.NeutralMode;
import frc.robot.Constants;

import com.revrobotics.CANSparkMax; 
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class IntakeWheelsSub extends SubsystemBase {
  //private static WPI_TalonFX intakeWheelMotor = new WPI_TalonFX(Constants.INTAKE_WHEEL_MOTOR_PORT);
  private static CANSparkMax intakeWheelMotor = new CANSparkMax(Constants.INTAKE_WHEEL_MOTOR_PORT, MotorType.kBrushless);
  /**
   * Creates a new AFineAdditionToMyCollection.
   */
  public IntakeWheelsSub() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    //intakeWheelMotor.setNeutralMode(NeutralMode.Brake);
    intakeWheelMotor.setIdleMode(IdleMode.kBrake);
  }

  public void m_spinWheelsIn(){
    intakeWheelMotor.set(Constants.INTAKE_WHEEL_MOTOR_SPEED);
  }

  public void m_spinWheelsOut(){
    intakeWheelMotor.set(-Constants.INTAKE_WHEEL_MOTOR_SPEED);
  }

  public void m_stopWheels(){
    intakeWheelMotor.stopMotor();
  }
}
