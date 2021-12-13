/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
 
package frc.robot.subsystems;
 
//import edu.wpi.first.wpilibj.SpeedController;
//import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

//import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
//import frc.robot.RobotContainer;
//import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;

//import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
//import com.ctre.phoenix.motorcontrol.FeedbackDevice;
//import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
 
 
public class DrivetrainSub extends SubsystemBase {

  private static TalonFX frontLeftMotor = new TalonFX(Constants.FRONT_LEFT_MOTOR_PORT);
  private static TalonFX rearLeftMotor = new TalonFX(Constants.REAR_LEFT_MOTOR_PORT);
  private static TalonFX frontRightMotor = new TalonFX(Constants.FRONT_RIGHT_MOTOR_PORT);
  private static TalonFX rearRightMotor = new TalonFX(Constants.REAR_RIGHT_MOTOR_PORT);
 
  //DifferentialDrive drive = new DifferentialDrive(frontLeftMotor, frontRightMotor);

  public DrivetrainSub() {
    /*frontLeftMotor.configFactoryDefault();
    rearLeftMotor.configFactoryDefault();
    frontRightMotor.configFactoryDefault();
    rearRightMotor.configFactoryDefault();

    frontLeftMotor.setNeutralMode(NeutralMode.Brake);
    rearLeftMotor.setNeutralMode(NeutralMode.Brake);
    frontRightMotor.setNeutralMode(NeutralMode.Brake);
    rearRightMotor.setNeutralMode(NeutralMode.Brake);

    rearLeftMotor.follow(frontLeftMotor);
    rearRightMotor.follow(frontRightMotor);

    rearLeftMotor.setInverted(InvertType.FollowMaster);
    rearRightMotor.setInverted(InvertType.FollowMaster);

    drive.setRightSideInverted(true);*/
  }

  public void m_arcadeDrive(double forward, double rotation, double throttle) {
    //drive.arcadeDrive(-forward*throttle, rotation*throttle*Constants.TURN_ADJUST);

    frontLeftMotor.setNeutralMode(NeutralMode.Brake);
    rearLeftMotor.setNeutralMode(NeutralMode.Brake);
    frontRightMotor.setNeutralMode(NeutralMode.Brake);
    rearRightMotor.setNeutralMode(NeutralMode.Brake);

    double leftPower = skim(((forward * throttle) - (rotation * throttle * Constants.TURN_ADJUST)));
    double rightPower = skim(((forward * throttle) + (rotation * throttle * Constants.TURN_ADJUST)));


      
    SmartDashboard.putNumber("leftPower", leftPower);
    SmartDashboard.putNumber("rightPower", rightPower);
    //RobotContainer.getRawAxis();

    //frontLeftMotor.set(leftPower);
    //rearLeftMotor.set(leftPower);
    //frontRightMotor.set(-rightPower);
    //rearRightMotor.set(-rightPower);

    frontLeftMotor.set(TalonFXControlMode.PercentOutput, leftPower);
    frontRightMotor.set(TalonFXControlMode.PercentOutput, -rightPower);
    rearLeftMotor.set(TalonFXControlMode.PercentOutput, leftPower);
    rearRightMotor.set(TalonFXControlMode.PercentOutput, -rightPower);

  }

  public double skim(double num){
    if (num > 1.0) {
      return 1.0;
    } else if (num < -1.0) {
      return -1.0;
    }
    else{
      return num;
    } 
  }
 
 
}

