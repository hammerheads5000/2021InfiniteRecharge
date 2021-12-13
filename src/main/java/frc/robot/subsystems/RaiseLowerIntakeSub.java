/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

//import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
//import edu.wpi.first.wpilibj.Spark;

public class RaiseLowerIntakeSub extends SubsystemBase {
  private static WPI_TalonSRX raiseIntakeMotor = new WPI_TalonSRX(Constants.RAISE_INTAKE_MOTOR_PORT);

  /**
   * Creates a new AnotherHappyLanding.
   */
  public RaiseLowerIntakeSub() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    raiseIntakeMotor.setNeutralMode(NeutralMode.Brake);
  }

  public void m_lowerIntake(){
    raiseIntakeMotor.set(Constants.RAISE_INTAKE_SPEED);
  }

  public void m_raiseIntake(){
    raiseIntakeMotor.set(-Constants.RAISE_INTAKE_SPEED);
  }

  public void m_stopMovingIntake(){
    raiseIntakeMotor.stopMotor();
  }

  public int m_getMotorSpeed(){
    //return raiseIntakeMotor.getSensorCollection().isFwdLimitSwitchClosed();
    return 0;
  }
}
